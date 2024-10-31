package com.razah.dev.bookstore.transaction.entities;

import com.razah.dev.bookstore.transaction.constant.OutletPosition;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CentralEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String employeeId;
    private OutletPosition position;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeCentral;
}
