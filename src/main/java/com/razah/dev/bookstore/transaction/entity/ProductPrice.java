package com.razah.dev.bookstore.transaction.entity;

import com.razah.dev.bookstore.transaction.constant.ConstantTable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ConstantTable.PRODUCT_PRICE)
@Getter
@Builder
@Setter
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Long price;

}
