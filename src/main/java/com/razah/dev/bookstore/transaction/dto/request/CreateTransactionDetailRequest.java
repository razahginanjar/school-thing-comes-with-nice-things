package com.razah.dev.bookstore.transaction.dto.request;

import com.razah.dev.bookstore.transaction.constant.OrderType;
import com.razah.dev.bookstore.transaction.entity.Product;
import com.razah.dev.bookstore.transaction.entity.Transaction;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTransactionDetailRequest {
    private Integer quantity;

    private String productCode;
}
