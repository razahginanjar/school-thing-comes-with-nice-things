package com.razah.dev.bookstore.transaction.mapper.impl;

import com.razah.dev.bookstore.transaction.dto.response.TransactionResponse;
import com.razah.dev.bookstore.transaction.entity.Transaction;
import com.razah.dev.bookstore.transaction.mapper.TransactionMapper;
import org.springframework.stereotype.Service;

@Service
public class TransactionMapperImpl implements TransactionMapper {
    @Override
    public TransactionResponse map(Transaction transaction) {
        return null;
    }
}
