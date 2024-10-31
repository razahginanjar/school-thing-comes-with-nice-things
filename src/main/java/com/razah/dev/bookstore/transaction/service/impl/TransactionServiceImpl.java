package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.*;
import com.razah.dev.bookstore.transaction.dto.response.TransactionResponse;
import com.razah.dev.bookstore.transaction.entities.Transaction;
import com.razah.dev.bookstore.transaction.entities.TransactionDetail;
import com.razah.dev.bookstore.transaction.mapper.TransactionMapper;
import com.razah.dev.bookstore.transaction.repository.TransactionRepository;
import com.razah.dev.bookstore.transaction.service.OutletService;
import com.razah.dev.bookstore.transaction.service.TransactionDetailService;
import com.razah.dev.bookstore.transaction.service.TransactionService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final ValidationUtil validationUtil;
    private final TransactionRepository transactionRepository;
    private final OutletService outletService;
    private final TransactionDetailService transactionDetailService;
    private final TransactionMapper transactionMapper;
    private final CustomerServiceImpl customerServiceImpl;


    @Override
    public Transaction create(CreateTransactionRequest request) {
        validationUtil.validate(request);
        Transaction transaction = new Transaction();
        transaction.setCustomerTransaction(customerServiceImpl.getByUser());
        transaction.setTransactionDate(LocalDate.now());
        transaction.setOutletTransaction(outletService.getByCode(request.getCodeOutlet()));

        List<TransactionDetail> list = request.getDetailRequests().stream().map(
                createTransactionDetailRequest -> transactionDetailService.create(createTransactionDetailRequest, transaction)
        ).toList();

        transaction.setTransactionDetails(list);
        return transactionRepository.saveAndFlush(transaction);
    }

    @Override
    public Transaction update(UpdateTransactionRequest request) {
        validationUtil.validate(request);
        Transaction byId = getById(request.getId());
        byId.setTransactionDetails(request.getDetailRequests().stream().map(
                updateTransactionDetailRequest -> transactionDetailService.update(updateTransactionDetailRequest, byId)
        ).toList());
        byId.setOutletTransaction(outletService.getByCode(request.getCodeOutlet()));
        byId.setPaymentType(request.getPaymentType());
        return transactionRepository.saveAndFlush(byId);
    }

    @Override
    public Transaction updateOrderType(UpdateTransactionOrderType orderType) {
        validationUtil.validate(orderType);
        Transaction byId = getById(orderType.getId());
        byId.setPaymentType(orderType.getPaymentType());

        List<UpdateTransactionDetailRequest> list = byId.getTransactionDetails().stream().map(
                transactionDetail -> {
                    UpdateTransactionDetailRequest request = new UpdateTransactionDetailRequest();
                    request.setProductCode(transactionDetail.getProductTransaction().getCode());
                    request.setQuantity(transactionDetail.getQuantity());
                    request.setId(transactionDetail.getId());
                    return request;
                }
        ).toList();

        UpdateTransactionRequest build = UpdateTransactionRequest.builder()
                .paymentType(byId.getPaymentType())
                .id(byId.getId())
                .detailRequests(list)
                .codeOutlet(byId.getOutletTransaction().getCode())
                .build();
        return update(build);
    }

    @Override
    public Transaction updateProducts(UpdateTransactionProducts products) {
        validationUtil.validate(products);
        Transaction byId = getById(products.getIdTransaction());
        List<TransactionDetail> list = products.getRequests().stream().map(
                updateTransactionDetailRequest -> transactionDetailService.update(updateTransactionDetailRequest, byId)
        ).toList();
        byId.setTransactionDetails(list);

        UpdateTransactionRequest build = UpdateTransactionRequest.builder()
                .detailRequests(products.getRequests())
                .id(byId.getId())
                .codeOutlet(byId.getOutletTransaction().getCode())
                .paymentType(byId.getPaymentType())
                .build();
        return update(build);
    }

    @Override
    public Transaction getById(String id) {
        if(Objects.isNull(id))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return transactionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }

    @Override
    public List<Transaction> getAll(String request) {
        return transactionRepository.findAll();
    }

    @Override
    public void delete(String id) {
        Transaction byId = getById(id);
        transactionRepository.delete(byId);
    }

    @Override
    public TransactionResponse createResponse(CreateTransactionRequest request) {
        Transaction transaction = create(request);
        return transactionMapper.map(transaction);
    }

    @Override
    public TransactionResponse updateResponse(UpdateTransactionRequest request) {
        Transaction update = update(request);
        return transactionMapper.map(update);
    }

    @Override
    public TransactionResponse getByIdResponse(String id) {
        Transaction byId = getById(id);
        return transactionMapper.map(byId);
    }

    @Override
    public List<TransactionResponse> getAllResponses(String request) {
        return getAll(request).stream().map(
                transactionMapper::map
        ).toList();
    }
}
