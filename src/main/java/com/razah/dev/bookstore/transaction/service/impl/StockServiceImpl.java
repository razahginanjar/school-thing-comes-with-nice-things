package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.CreateStockRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateStockRequest;
import com.razah.dev.bookstore.transaction.entity.Outlet;
import com.razah.dev.bookstore.transaction.entity.Product;
import com.razah.dev.bookstore.transaction.entity.StockProduct;
import com.razah.dev.bookstore.transaction.repository.StockProductRepository;
import com.razah.dev.bookstore.transaction.service.OutletService;
import com.razah.dev.bookstore.transaction.service.ProductService;
import com.razah.dev.bookstore.transaction.service.StockService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockProductRepository stockProductRepository;
    private final ValidationUtil validationUtil;

    @Override
    public StockProduct create(CreateStockRequest request, Outlet outlet, Product product) {
        validationUtil.validate(request);
        StockProduct stockProduct = new StockProduct();
        stockProduct.setStock(request.getStock());
        stockProduct.setOutletStock(outlet);
        stockProduct.setProductStock(product);
        return stockProductRepository.saveAndFlush(stockProduct);
    }

    @Override
    public StockProduct updateStock(UpdateStockRequest request) {
        StockProduct byId = getById(request.getId());
        byId.setStock(request.getStock());
        return stockProductRepository.saveAndFlush(byId);
    }

    @Override
    public StockProduct getById(String id) {
        if(Objects.isNull(id))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return stockProductRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }
}
