package com.razah.dev.bookstore.transaction.dto.response;

import com.razah.dev.bookstore.transaction.constant.OrderType;
import com.razah.dev.bookstore.transaction.entity.Product;
import com.razah.dev.bookstore.transaction.entity.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDetailResponse {

    private String id;

    private Long totalSales;

    private Integer quantity;

    private ProductResponse productTransaction;

    private OrderType orderType;
}
