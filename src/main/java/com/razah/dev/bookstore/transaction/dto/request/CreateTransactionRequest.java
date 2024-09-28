package com.razah.dev.bookstore.transaction.dto.request;

import com.razah.dev.bookstore.transaction.constant.OrderType;
import com.razah.dev.bookstore.transaction.entity.Customer;
import com.razah.dev.bookstore.transaction.entity.Outlet;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class CreateTransactionRequest {
    private String codeOutlet;
    private OrderType orderType;
    private List<CreateTransactionDetailRequest> detailRequests;
}
