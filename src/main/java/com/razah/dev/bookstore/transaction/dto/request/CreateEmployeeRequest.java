package com.razah.dev.bookstore.transaction.dto.request;

import com.razah.dev.bookstore.transaction.constant.PositionEmployee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEmployeeRequest {

    private String name;

    private String telephone;

    private String email;

    private PositionEmployee position;
}
