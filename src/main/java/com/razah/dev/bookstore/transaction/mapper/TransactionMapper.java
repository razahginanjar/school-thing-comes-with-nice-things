package com.razah.dev.bookstore.transaction.mapper;

import com.razah.dev.bookstore.transaction.dto.response.TransactionResponse;
import com.razah.dev.bookstore.transaction.entity.Transaction;

public interface TransactionMapper {
    TransactionResponse map(Transaction transaction);
}
