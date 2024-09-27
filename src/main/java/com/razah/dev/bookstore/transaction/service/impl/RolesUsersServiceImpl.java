package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.UsersRolesRequest;
import com.razah.dev.bookstore.transaction.entity.UsersRoles;
import com.razah.dev.bookstore.transaction.repository.RoleRepository;
import com.razah.dev.bookstore.transaction.service.RolesUsersService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class RolesUsersServiceImpl implements RolesUsersService {
    private final ValidationUtil validationUtil;
    private final RoleRepository usersRoleRepository;

    @Override
    public UsersRoles create(UsersRolesRequest request) {
        if(Objects.isNull(request.getRole()))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return usersRoleRepository.findByRoles(request.getRole()).orElseGet(
                () -> usersRoleRepository.saveAndFlush(
                        UsersRoles.builder()
                                .roles(request.getRole())
                                .build()
                )
        );
    }
}
