package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.UsersRolesRequest;
import com.razah.dev.bookstore.transaction.entities.UsersRoles;

public interface RolesUsersService {
    UsersRoles create(UsersRolesRequest request);
}
