package com.razah.dev.bookstore.transaction.entity;

import com.razah.dev.bookstore.transaction.constant.ConstantTable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock_product")
@Getter
@Setter
@Builder
public class StockProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productStock;

    @ManyToOne
    @JoinColumn(name = "outlet_id")
    private Outlet outletStock;

    private Integer stock;
}
