package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.UsersRolesRequest;
import com.razah.dev.bookstore.transaction.entity.UsersRoles;

import java.util.List;

public interface RolesUsersService {
    UsersRoles create(UsersRolesRequest request);
}
