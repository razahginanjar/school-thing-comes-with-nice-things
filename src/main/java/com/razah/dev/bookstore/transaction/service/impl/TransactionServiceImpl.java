package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.CreateTransactionRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateTransactionRequest;
import com.razah.dev.bookstore.transaction.dto.response.TransactionResponse;
import com.razah.dev.bookstore.transaction.entity.Transaction;
import com.razah.dev.bookstore.transaction.service.TransactionService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final ValidationUtil validationUtil;

    @Override
    public Transaction create(CreateTransactionRequest request) {
        return null;
    }

    @Override
    public Transaction update(UpdateTransactionRequest request) {
        return null;
    }

    @Override
    public Transaction getById(String id) {
        return null;
    }

    @Override
    public List<Transaction> getAll(String request) {
        return List.of();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public TransactionResponse createResponse(CreateTransactionRequest request) {
        return null;
    }

    @Override
    public TransactionResponse updateResponse(UpdateTransactionRequest request) {
        return null;
    }

    @Override
    public TransactionResponse getByIdResponse(String id) {
        return null;
    }

    @Override
    public List<TransactionResponse> getAllResponses(String request) {
        return List.of();
    }
}
