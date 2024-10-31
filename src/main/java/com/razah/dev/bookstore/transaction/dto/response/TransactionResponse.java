package com.razah.dev.bookstore.transaction.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {

    private String id;

    private CustomerResponse customerTransaction;

    private LocalDate transactionDate;

    private OutletResponse outletTransaction;

    private List<TransactionDetailResponse> transactionDetails;
}
