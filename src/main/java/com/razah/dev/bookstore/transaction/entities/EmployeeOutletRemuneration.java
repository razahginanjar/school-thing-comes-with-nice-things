package com.razah.dev.bookstore.transaction.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
public class EmployeeOutletRemuneration {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "base_salary")
    private Long baseSalary;
    @Column(name = "allowances")
    private Long allowances;
    @Column(name = "deduction")
    private Long deductions;
    @Column(name = "net_salary")
    private Long netSalary;

    @Column(name = "pay_date")
    private LocalDate payDate;

    @ManyToOne
    @JoinColumn(name = "outlet_employee_id")
    private Employee outletEmployee;

}
