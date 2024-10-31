package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.CreateProductPriceRequest;
import com.razah.dev.bookstore.transaction.entities.PhotoPrice;
import com.razah.dev.bookstore.transaction.repository.ProductPriceRepository;
import com.razah.dev.bookstore.transaction.service.ProductPriceService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPriceServiceImpl implements ProductPriceService {
    private final ProductPriceRepository productPriceRepository;
    private final ValidationUtil validationUtil;

    @Override
    public PhotoPrice create(CreateProductPriceRequest request) {
        return productPriceRepository.findByPrice(request.getPrice()).orElseGet(
                () -> productPriceRepository.saveAndFlush(
                        PhotoPrice.builder()
                                .price(request.getPrice())
                                .build()
                )
        );
    }
}
