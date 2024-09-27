package com.razah.dev.bookstore.transaction.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    @NotNull
    @NotBlank
    private String id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String telephone;
}
