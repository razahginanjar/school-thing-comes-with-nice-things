package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.CreateDiscountRequest;
import com.razah.dev.bookstore.transaction.entities.Discount;
import com.razah.dev.bookstore.transaction.repository.DiscountRepository;
import com.razah.dev.bookstore.transaction.service.DiscountService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final ValidationUtil validationUtil;
    @Override
    public Discount getOrSave(CreateDiscountRequest createDiscountRequest) {
        validationUtil.validate(createDiscountRequest);
        return discountRepository.findByDiscount(createDiscountRequest.getPercentageDiscount()).orElseGet(
                () -> discountRepository.saveAndFlush(
                        Discount.builder().discount(createDiscountRequest.getPercentageDiscount())
                                .requiredPoints(createDiscountRequest.getRequiredPoint())
                                .build()
                )
        );
    }
}
