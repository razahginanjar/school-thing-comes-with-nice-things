package com.razah.dev.bookstore.transaction.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEmployeeRequest {
    private String id;

    private String name;

    private String telephone;

    private String email;

    private String position;
}