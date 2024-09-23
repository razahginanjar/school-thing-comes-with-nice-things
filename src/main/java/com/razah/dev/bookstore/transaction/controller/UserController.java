package com.razah.dev.bookstore.transaction.controller;

import com.razah.dev.bookstore.transaction.constant.APIUrl;
import com.razah.dev.bookstore.transaction.dto.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = APIUrl.USER)
@RequiredArgsConstructor
public class UserController {

    @PutMapping(

    )
    public ResponseEntity<CommonResponse<?>> addRole(@RequestBody UpdateEmployee updateEmployee)
    {

        return ResponseEntity.status().body();
    }
}
