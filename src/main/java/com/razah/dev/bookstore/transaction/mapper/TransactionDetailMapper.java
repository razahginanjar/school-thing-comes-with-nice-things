package com.razah.dev.bookstore.transaction.mapper;

import com.razah.dev.bookstore.transaction.dto.response.TransactionDetailResponse;
import com.razah.dev.bookstore.transaction.entities.TransactionDetail;

public interface TransactionDetailMapper {
    TransactionDetailResponse map(TransactionDetail transactionDetail);
}
