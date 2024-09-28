package com.razah.dev.bookstore.transaction.dto.response;

import com.razah.dev.bookstore.transaction.entity.ProductPrice;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private String id;

    private String code;

    private ProductPriceResponse price;
}
