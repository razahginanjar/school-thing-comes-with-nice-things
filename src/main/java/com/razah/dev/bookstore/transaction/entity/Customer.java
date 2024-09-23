package com.razah.dev.bookstore.transaction.entity;

import com.razah.dev.bookstore.transaction.constant.ConstantTable;
import jakarta.persistence.*;
import lombok.*;

import java.lang.constant.Constable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ConstantTable.CUSTOMER)
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String telephone;

    private String email;
}
