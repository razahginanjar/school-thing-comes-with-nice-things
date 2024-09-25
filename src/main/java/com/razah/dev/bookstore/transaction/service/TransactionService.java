package com.razah.dev.bookstore.transaction.service;



import com.razah.dev.bookstore.transaction.dto.request.CreateTransactionRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateTransactionRequest;
import com.razah.dev.bookstore.transaction.dto.response.TransactionResponse;
import com.razah.dev.bookstore.transaction.entity.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction create(CreateTransactionRequest request);
    Transaction update(UpdateTransactionRequest request);
    Transaction getById(String id);
    List<Transaction> getAll(String request);
    void delete(String id);

    TransactionResponse createResponse(CreateTransactionRequest request);
    TransactionResponse updateResponse(UpdateTransactionRequest request);
    TransactionResponse getByIdResponse(String id);
    List<TransactionResponse> getAllResponses(String request);
}
