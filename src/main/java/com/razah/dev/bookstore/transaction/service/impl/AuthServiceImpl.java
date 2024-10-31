package com.razah.dev.bookstore.transaction.service.impl;


import com.razah.dev.bookstore.transaction.constant.Roles;
import com.razah.dev.bookstore.transaction.dto.request.*;
import com.razah.dev.bookstore.transaction.dto.response.CustomerResponse;
import com.razah.dev.bookstore.transaction.dto.response.EmployeeResponse;
import com.razah.dev.bookstore.transaction.dto.response.LoginResponse;
import com.razah.dev.bookstore.transaction.dto.response.RegisterResponse;
import com.razah.dev.bookstore.transaction.entities.Users;
import com.razah.dev.bookstore.transaction.entities.UsersRoles;
import com.razah.dev.bookstore.transaction.repository.UserRepository;
import com.razah.dev.bookstore.transaction.service.AuthService;
import com.razah.dev.bookstore.transaction.service.EmployeeService;
import com.razah.dev.bookstore.transaction.service.JwtService;
import com.razah.dev.bookstore.transaction.service.RolesUsersService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    private final RolesUsersService roleService;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeService employeeService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ValidationUtil validation;
    private final CustomerServiceImpl customerServiceImpl;

    @Value("${maju_mundur.superadmin.username}")
    private String superAdminUsername;
    @Value("${maju_mundur.superadmin.password}")
    private String superAdminPassword;

    @PostConstruct
    @Transactional(rollbackFor = Exception.class)
    public void init() {
        Optional<Users> userSuperAdmin = userRepository.findByUsername(superAdminUsername);
        if (userSuperAdmin.isPresent()) return;

        UsersRoles admin = roleService.create(UsersRolesRequest.builder().role(Roles.ROLE_ADMINISTRATOR).build());
        UsersRoles merchant = roleService.create(UsersRolesRequest.builder().role(Roles.ROLE_EMPLOYEE).build());
        UsersRoles customer = roleService.create(UsersRolesRequest.builder().role(Roles.ROLE_CUSTOMER).build());

        Users account = Users.builder()
                .username(superAdminUsername)
                .password(passwordEncoder.encode(superAdminPassword))
                .usersRoles(List.of(admin, merchant, customer))
                .build();
        userRepository.save(account);
    }

    @Override
    public LoginResponse login(LoginRequest request) throws DataIntegrityViolationException {
        validation.validate(request);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );

        Authentication authenticated = authenticationManager.authenticate(authentication);
        Users account = (Users) authenticated.getPrincipal();
        String token = jwtService.generateToken(account);
        return LoginResponse.builder()
                .token(token)
                .username(account.getUsername())
                .roles(account.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .build();
    }

    @Override
    public RegisterResponse registerEmployee(RegisterEmployeeRequest request) {
        validation.validate(request);
        UsersRoles merchant = roleService.create(UsersRolesRequest.builder().role(Roles.ROLE_EMPLOYEE).build());
        UsersRoles customer = roleService.create(UsersRolesRequest.builder().role(Roles.ROLE_CUSTOMER).build());
        String hashPassword = passwordEncoder.encode(request.getPassword());
        Users user = Users.builder()
                .username(request.getUsername())
                .password(hashPassword)
                .usersRoles(List.of(merchant, customer))
                .build();
        userRepository.saveAndFlush(user);

        CreateEmployeeRequest build = CreateEmployeeRequest.builder()
                .position(request.getPositionEmployee())
                .name(request.getName())
                .telephone(request.getPhoneNumber())
                .email(request.getEmail())
                .build();
        EmployeeResponse employee = employeeService.createResponse(build, user);

        return RegisterResponse.builder()
                .username(user.getUsername())
                .roles(user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .employee(employee)
                .build();
    }

    @Override
    public RegisterResponse registerCustomer(RegisterCustomer request) {
        validation.validate(request);
        UsersRoles customer = roleService.create(UsersRolesRequest.builder().role(Roles.ROLE_CUSTOMER).build());
        String hashPassword = passwordEncoder.encode(request.getPassword());
        Users user = Users.builder()
                .username(request.getUsername())
                .password(hashPassword)
                .usersRoles(List.of(customer))
                .build();
        userRepository.saveAndFlush(user);

        CreateCustomerRequest createCustomerRequest = CreateCustomerRequest.builder()
                .name(request.getName())
                .telephone(request.getPhoneNumber())
                .email(request.getEmail())
                .build();
        CustomerResponse customerResponse = customerServiceImpl.createCustomerResponse(createCustomerRequest, user);

        return RegisterResponse.builder()
                .username(user.getUsername())
                .roles(user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .customer(customerResponse)
                .build();
    }
}
