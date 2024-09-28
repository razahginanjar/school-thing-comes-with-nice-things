package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.*;
import com.razah.dev.bookstore.transaction.dto.response.TransactionDetailResponse;
import com.razah.dev.bookstore.transaction.dto.response.TransactionResponse;
import com.razah.dev.bookstore.transaction.entity.*;
import com.razah.dev.bookstore.transaction.mapper.impl.TransactionDetailMapperImpl;
import com.razah.dev.bookstore.transaction.mapper.impl.TransactionMapperImpl;
import com.razah.dev.bookstore.transaction.repository.TransactionDetailRepository;
import com.razah.dev.bookstore.transaction.service.TransactionDetailService;
import com.razah.dev.bookstore.transaction.service.TransactionService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TransactionDetailServiceImpl implements TransactionDetailService {
    private final ValidationUtil validationUtil;
    private final TransactionDetailRepository transactionDetailRepository;
    private final ProductServiceImpl productService;
    private final TransactionDetailMapperImpl transactionDetailMapperImpl;
    private final StockServiceImpl stockService;


    @Override
    public TransactionDetail create(CreateTransactionDetailRequest request, Transaction transaction) {
        validationUtil.validate(request);
        TransactionDetail transactionDetail = new TransactionDetail();

        Product byCode = productService.getByCode(request.getProductCode());

        transactionDetail.setProductTransaction(byCode);
        StockProduct byOutletAndProduct = stockService.getByOutletAndProduct(transaction.getOutletTransaction(), byCode);

        if(byOutletAndProduct.getStock() < request.getQuantity()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }

        transactionDetail.setQuantity(request.getQuantity());

        transactionDetail.setTotalSales(byCode.getProductPrice().getPrice() * request.getQuantity());

        transactionDetail.setTransaction(transaction);
        UpdateStockRequest build = UpdateStockRequest.builder()
                .id(byOutletAndProduct.getId())
                .stock(byOutletAndProduct.getStock() - request.getQuantity())
                .build();
        stockService.updateStock(build);

        return transactionDetailRepository.saveAndFlush(transactionDetail);
    }
    @Override
    public TransactionDetail updateQuantity(UpdateTransactionDetailQuantity quantity, Transaction transaction) {
        validationUtil.validate(quantity);
        TransactionDetail byId = getById(quantity.getId());
        UpdateTransactionDetailRequest request = new UpdateTransactionDetailRequest();
        request.setQuantity(quantity.getQuantity());
        request.setProductCode(byId.getProductTransaction().getCode());
        return update(request, transaction);
    }

    @Override
    public TransactionDetail update(UpdateTransactionDetailRequest request, Transaction transaction) {
        validationUtil.validate(request);
        Product byCode = productService.getByCode(request.getProductCode());
        TransactionDetail byId = getById(request.getId());
        Product productTransaction = byId.getProductTransaction();
        Outlet outletTransaction = transaction.getOutletTransaction();

        StockProduct byOutletAndProduct = stockService.getByOutletAndProduct(outletTransaction, productTransaction);
        UpdateStockRequest build = UpdateStockRequest
                .builder()
                .stock(byOutletAndProduct.getStock() + byId.getQuantity())
                .id(byOutletAndProduct.getId())
                .build();
        stockService.updateStock(build);
        byId.setQuantity(request.getQuantity());
        byId.setTotalSales(byCode.getProductPrice().getPrice() * request.getQuantity());
        byId.setTransaction(transaction);
        byId.setProductTransaction(byCode);

        StockProduct byOutletAndProduct1 = stockService.getByOutletAndProduct(transaction.getOutletTransaction(), byCode);

        if(byOutletAndProduct1.getStock() < request.getQuantity()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }

        UpdateStockRequest build1 = UpdateStockRequest.builder()
                .id(byOutletAndProduct1.getId())
                .stock(byOutletAndProduct1.getStock() - request.getQuantity())
                .build();
        stockService.updateStock(build1);
        return transactionDetailRepository.saveAndFlush(byId);
    }

    @Override
    public TransactionDetail getById(String id) {
        if(Objects.isNull(id))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return transactionDetailRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }

    @Override
    public List<TransactionDetail> getAll() {
        return transactionDetailRepository.findAll();
    }

    @Override
    public void delete(String id) {
        TransactionDetail byId = getById(id);
        transactionDetailRepository.delete(byId);
    }

    @Override
    public TransactionDetailResponse createResponse(CreateTransactionDetailRequest request, Transaction transaction) {
        TransactionDetail transactionDetail = create(request, transaction);
        return transactionDetailMapperImpl.map(transactionDetail);
    }

    @Override
    public TransactionDetailResponse updateResponse(UpdateTransactionDetailRequest request, Transaction transaction) {
        TransactionDetail update = update(request, transaction);
        return transactionDetailMapperImpl.map(update);
    }

    @Override
    public TransactionDetailResponse updateQuantityResponse(UpdateTransactionDetailQuantity quantity, Transaction transaction) {
        TransactionDetail transactionDetail = updateQuantity(quantity, transaction);
        return transactionDetailMapperImpl.map(transactionDetail);
    }

    @Override
    public TransactionDetailResponse getByIdResponse(String id) {
        TransactionDetail byId = getById(id);
        return transactionDetailMapperImpl.map(byId);
    }

    @Override
    public List<TransactionDetailResponse> getAllResponses() {
        return getAll().stream().map(
                transactionDetailMapperImpl::map
        ).toList();
    }

}
