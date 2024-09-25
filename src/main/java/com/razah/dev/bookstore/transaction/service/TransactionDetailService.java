package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CreateTransactionDetailRequest;
import com.razah.dev.bookstore.transaction.dto.request.CreateTransactionRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateTransactionDetailRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateTransactionRequest;
import com.razah.dev.bookstore.transaction.dto.response.TransactionResponse;
import com.razah.dev.bookstore.transaction.entity.Transaction;
import com.razah.dev.bookstore.transaction.entity.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {
    TransactionDetail create(CreateTransactionDetailRequest request);
    TransactionDetail update(UpdateTransactionDetailRequest request);
    TransactionDetail getById(String id);
    List<TransactionDetail> getAll(String request);
    void delete(String id);

    TransactionResponse createResponse(CreateTransactionDetailRequest request);
    TransactionResponse updateResponse(UpdateTransactionDetailRequest request);
    TransactionResponse getByIdResponse(String id);
    List<TransactionResponse> getAllResponses(String request);
}
