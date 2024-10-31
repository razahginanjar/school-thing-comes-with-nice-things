package com.razah.dev.bookstore.transaction.entities;

import com.razah.dev.bookstore.transaction.constant.ConstantTable;
import jakarta.persistence.*;
import lombok.*;


@Builder
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

    private Integer points;

    @Column(unique = true, nullable = false)
    private String telephone;
    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users usersCustomer;
}
