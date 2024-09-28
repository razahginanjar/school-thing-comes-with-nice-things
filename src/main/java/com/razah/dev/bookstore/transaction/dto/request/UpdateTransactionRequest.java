package com.razah.dev.bookstore.transaction.dto.request;

import com.razah.dev.bookstore.transaction.constant.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTransactionRequest {
    private String id;
    private String codeOutlet;
    private OrderType orderType;
    private List<UpdateTransactionDetailRequest> detailRequests;
}
