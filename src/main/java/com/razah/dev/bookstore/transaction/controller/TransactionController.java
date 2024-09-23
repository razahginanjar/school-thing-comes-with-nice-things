package com.razah.dev.bookstore.transaction.controller;

import com.razah.dev.bookstore.transaction.constant.APIUrl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = APIUrl.TRANSACTION)
@RequiredArgsConstructor
public class TransactionController {
}
