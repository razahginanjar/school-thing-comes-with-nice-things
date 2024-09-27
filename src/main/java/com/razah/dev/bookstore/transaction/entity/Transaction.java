package com.razah.dev.bookstore.transaction.entity;

import com.razah.dev.bookstore.transaction.constant.ConstantTable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ConstantTable.TRANSACTION)
@Getter
@Setter
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerTransaction;


    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @ManyToOne
    @JoinColumn(name = "outlet_id")
    private Outlet outletTransaction;

    @OneToMany(mappedBy = "transaction")
    private List<TransactionDetail> transactionDetails;
}
