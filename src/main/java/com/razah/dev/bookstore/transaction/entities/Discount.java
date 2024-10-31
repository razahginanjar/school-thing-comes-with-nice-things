package com.razah.dev.bookstore.transaction.entities;

import com.razah.dev.bookstore.transaction.constant.PercentageDiscount;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m_discount")
@Getter
@Setter
@Builder
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "reward_id", nullable = false, updatable = false, unique = true)
    private String id;

    @Column(name = "reward_name")
    @Enumerated(EnumType.STRING)
    private PercentageDiscount discount;

    @Column(name = "required_points")
    private Integer requiredPoints;

    @Column(name = "expired_in_days")
    private Integer expiredInDays;
}
