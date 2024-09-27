package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.constant.Roles;
import com.razah.dev.bookstore.transaction.dto.request.CreateCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdatePointsCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.response.CustomerResponse;
import com.razah.dev.bookstore.transaction.entity.Customer;
import com.razah.dev.bookstore.transaction.entity.Users;
import com.razah.dev.bookstore.transaction.entity.UsersRoles;
import com.razah.dev.bookstore.transaction.mapper.impl.CustomerMapperImpl;
import com.razah.dev.bookstore.transaction.repository.CustomerRepository;
import com.razah.dev.bookstore.transaction.service.CustomerService;
import com.razah.dev.bookstore.transaction.service.UserService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final UserService userService;
    private final ValidationUtil validationUtils;
    private final CustomerMapperImpl customerMapperImpl;

    @Override
    public Customer createCustomer(CreateCustomerRequest createCustomerRequest, Users users) {
        validationUtils.validate(createCustomerRequest);
        Customer customer = new Customer();
        customer.setName(createCustomerRequest.getName());
        customer.setTelephone(createCustomerRequest.getTelephone());
        customer.setEmail(createCustomerRequest.getEmail());
        customer.setPoints(0);
        customer.setUsersCustomer(users);
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer update(UpdateCustomerRequest request) {
        validationUtils.validate(request);
        Users byContext = userService.getByContext();
        Customer byId = getById(request.getId());
        List<Roles> list = byContext.getUsersRoles().stream().map(
                UsersRoles::getRoles
        ).toList();
        if(!list.contains(Roles.ROLE_ADMINISTRATOR) && !list.contains(Roles.ROLE_EMPLOYEE))
        {
            if(!byId.getUsersCustomer().getId().equals(byContext.getId()))
            {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.getReasonPhrase());
            }
        }
        byId.setName(request.getName());
        byId.setEmail(request.getEmail());
        if(customerRepository.existsByTelephone(request.getTelephone()))
        {
            throw new ResponseStatusException(HttpStatus.CONFLICT, HttpStatus.CONFLICT.getReasonPhrase());
        }
        byId.setTelephone(request.getTelephone());
        return customerRepository.saveAndFlush(byId);
    }

    @Override
    public Customer getById(String id) {
        if(Objects.isNull(id))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return customerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updatePoints(UpdatePointsCustomerRequest request) {
        validationUtils.validate(request);
        Customer byId = getById(request.getId());
        byId.setPoints(request.getPoints());
        return customerRepository.saveAndFlush(byId);
    }

    @Override
    public Customer getByUser() {
        Users byContext = userService.getByContext();
        return customerRepository.findCustomerByUsersCustomer(byContext).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }

    @Override
    public void deleteById(String id) {
        Customer byId = getById(id);
        Users usersCustomer = byId.getUsersCustomer();
        customerRepository.delete(byId);
        userService.deleteUserByID(usersCustomer.getId());
    }

    @Override
    public CustomerResponse createCustomerResponse(CreateCustomerRequest createCustomerRequest, Users users) {
        Customer customer = createCustomer(createCustomerRequest, users);
        return customerMapperImpl.map(customer);
    }

    @Override
    public CustomerResponse updateResponse(UpdateCustomerRequest request) {
        Customer update = update(request);
        return customerMapperImpl.map(update);
    }

    @Override
    public CustomerResponse getByIdResponse(String id) {
        Customer byId = getById(id);
        return customerMapperImpl.map(byId);
    }

    @Override
    public List<CustomerResponse> getAllResponses() {
        return getAll().stream().map(
                customerMapperImpl::map
        ).toList();
    }

    @Override
    public CustomerResponse getByUserResponse() {
        return customerMapperImpl.map(getByUser());
    }
}
