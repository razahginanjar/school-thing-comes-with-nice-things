package com.razah.dev.bookstore.transaction.entity;

import com.razah.dev.bookstore.transaction.constant.ConstantTable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ConstantTable.PRODUCT)
@Getter
@Setter
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "product_price_id")
    private ProductPrice productPrice;


}
