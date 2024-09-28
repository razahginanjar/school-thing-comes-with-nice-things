package com.razah.dev.bookstore.transaction.dto.request;

import com.razah.dev.bookstore.transaction.constant.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTransactionOrderType {
    private String id;
    private OrderType orderType;
}
