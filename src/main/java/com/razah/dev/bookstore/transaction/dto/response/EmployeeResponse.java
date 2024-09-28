package com.razah.dev.bookstore.transaction.dto.response;

import com.razah.dev.bookstore.transaction.constant.PositionEmployee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {

    private String id;

    private String name;

    private String telephone;

    private String email;

    private PositionEmployee position;
}
