package com.razah.dev.bookstore.transaction.controller;

import com.razah.dev.bookstore.transaction.dto.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BookProductController {
    @PostMapping(

    )
    public ResponseEntity<CommonResponse<?>> create(@RequestBody UpdateEmployee updateEmployee)
    {

        return ResponseEntity.status().body();
    }
    @GetMapping(

    )
    public ResponseEntity<CommonResponse<?>> getById(@RequestBody UpdateEmployee updateEmployee)
    {

        return ResponseEntity.status().body();
    }
    @GetMapping(

    )
    public ResponseEntity<CommonResponse<?>> getAll(@RequestBody UpdateEmployee updateEmployee)
    {

        return ResponseEntity.status().body();
    }
    @PutMapping(

    )
    public ResponseEntity<CommonResponse<?>> update(@RequestBody UpdateEmployee updateEmployee)
    {

        return ResponseEntity.status().body();
    }
    @DeleteMapping(

    )
    public ResponseEntity<CommonResponse<?>> delete(@RequestBody UpdateEmployee updateEmployee)
    {

        return ResponseEntity.status().body();
    }
}
