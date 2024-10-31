package com.razah.dev.bookstore.transaction.entities;

import com.razah.dev.bookstore.transaction.constant.Days;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
@Setter
@Getter
public class StoreWorkSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String scheduleId;

    private Days day;

    @OneToMany(mappedBy = "schedule")
    private List<OutletEmployee> employees;
}
