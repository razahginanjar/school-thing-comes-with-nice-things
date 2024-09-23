package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.UsersRolesRequest;
import com.razah.dev.bookstore.transaction.entity.UsersRoles;
import com.razah.dev.bookstore.transaction.service.RolesUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RolesUsersServiceImpl implements RolesUsersService {
    @Override
    public UsersRoles create(UsersRolesRequest request) {
        return null;
    }

    @Override
    public UsersRoles update(UsersRolesRequest request) {
        return null;
    }

    @Override
    public UsersRoles getById(String id) {
        return null;
    }

    @Override
    public List<UsersRoles> getAll(String request) {
        return List.of();
    }

    @Override
    public void delete(String id) {

    }
}
