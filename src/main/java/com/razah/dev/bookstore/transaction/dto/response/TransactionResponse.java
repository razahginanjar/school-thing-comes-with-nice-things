package com.razah.dev.bookstore.transaction.dto.response;

import com.razah.dev.bookstore.transaction.entity.Customer;
import com.razah.dev.bookstore.transaction.entity.Outlet;
import com.razah.dev.bookstore.transaction.entity.TransactionDetail;
import jakarta.persistence.*;
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
