package com.razah.dev.bookstore.transaction.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePointsCustomerRequest {
    @NotNull
    @NotBlank
    private String id;
    @NotNull
    private Integer points;
}
