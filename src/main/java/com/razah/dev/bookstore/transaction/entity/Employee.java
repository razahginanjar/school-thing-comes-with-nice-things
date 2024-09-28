package com.razah.dev.bookstore.transaction.entity;

import com.razah.dev.bookstore.transaction.constant.ConstantTable;
import com.razah.dev.bookstore.transaction.constant.PositionEmployee;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ConstantTable.EMPLOYEE)
@Getter
@Setter
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @Column(unique = true, nullable = false)
    private String telephone;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private PositionEmployee position; // sementara nanti ada entity lagi buat slip gaji

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users usersEmployee;

}
