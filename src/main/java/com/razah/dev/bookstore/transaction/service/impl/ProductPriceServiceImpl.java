package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.CreateProductPriceRequest;
import com.razah.dev.bookstore.transaction.entity.ProductPrice;
import com.razah.dev.bookstore.transaction.repository.ProductPriceRepository;
import com.razah.dev.bookstore.transaction.service.ProductPriceService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductPriceServiceImpl implements ProductPriceService {
    private final ProductPriceRepository productPriceRepository;
    private final ValidationUtil validationUtil;

    @Override
    public ProductPrice create(CreateProductPriceRequest request) {
        return productPriceRepository.findByPrice(request.getPrice()).orElseGet(
                () -> productPriceRepository.saveAndFlush(
                        ProductPrice.builder()
                                .price(request.getPrice())
                                .build()
                )
        );
    }
}
