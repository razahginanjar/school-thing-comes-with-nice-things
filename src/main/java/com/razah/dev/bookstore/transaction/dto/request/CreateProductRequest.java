package com.razah.dev.bookstore.transaction.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductRequest {
    private String id;

    private String name;

    private String description;

    private CreateProductPriceRequest price;
}
