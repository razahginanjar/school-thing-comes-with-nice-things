package com.razah.dev.bookstore.transaction.entities;


import com.razah.dev.bookstore.transaction.constant.ConstantTable;
import com.razah.dev.bookstore.transaction.constant.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = ConstantTable.PAYMENTS)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String token;

    @Column(name = "redirect_url")
    private String redirectUrl;

    @Column(name = "transaction_status")
    private PaymentStatus transactionStatus;
}
