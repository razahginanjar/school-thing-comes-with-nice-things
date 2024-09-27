package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.entity.Users;
import com.razah.dev.bookstore.transaction.repository.UserRepository;
import com.razah.dev.bookstore.transaction.service.UserService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository usersRepository;

    @Override
    public Users getUserByID(String idUser) {
        if(Objects.isNull(idUser))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return usersRepository.findById(idUser).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }

    @Override
    public Users getByContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return usersRepository.findByUsername(authentication.getPrincipal().toString()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.getReasonPhrase())
        );
    }

    @Override
    public void deleteUserByID(String idUser)
    {
        Users userByID = getUserByID(idUser);
        usersRepository.delete(userByID);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByUsername(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.getReasonPhrase())
        );
    }
}
