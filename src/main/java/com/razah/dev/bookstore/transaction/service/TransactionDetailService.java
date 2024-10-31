package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.*;
import com.razah.dev.bookstore.transaction.dto.response.TransactionDetailResponse;
import com.razah.dev.bookstore.transaction.entities.Transaction;
import com.razah.dev.bookstore.transaction.entities.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {
    TransactionDetail create(CreateTransactionDetailRequest request, Transaction transaction);
    TransactionDetail updateQuantity(UpdateTransactionDetailQuantity quantity, Transaction transaction);
    TransactionDetail update(UpdateTransactionDetailRequest request, Transaction transaction);
    TransactionDetail getById(String id);
    List<TransactionDetail> getAll();
    void delete(String id);

    TransactionDetailResponse createResponse(CreateTransactionDetailRequest request, Transaction transaction);
    TransactionDetailResponse updateResponse(UpdateTransactionDetailRequest request, Transaction transaction);
    TransactionDetailResponse updateQuantityResponse(UpdateTransactionDetailQuantity quantity, Transaction transaction);
    TransactionDetailResponse getByIdResponse(String id);
    List<TransactionDetailResponse> getAllResponses();
}
