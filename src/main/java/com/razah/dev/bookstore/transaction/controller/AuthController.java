package com.razah.dev.bookstore.transaction.controller;

import com.razah.dev.bookstore.transaction.constant.APIUrl;
import com.razah.dev.bookstore.transaction.dto.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = APIUrl.AUTH)
@RequiredArgsConstructor
public class AuthController {
    @GetMapping(

    )
    public ResponseEntity<CommonResponse<?>> login(@RequestBody UpdateEmployee updateEmployee)
    {

        return ResponseEntity.status().body();
    }
    @GetMapping(

    )
    public ResponseEntity<CommonResponse<?>> registerEmployee(@RequestBody UpdateEmployee updateEmployee)
    {

        return ResponseEntity.status().body();
    }

    @GetMapping(

    )
    public ResponseEntity<CommonResponse<?>> registerCustomer(@RequestBody UpdateEmployee updateEmployee)
    {

        return ResponseEntity.status().body();
    }
}
