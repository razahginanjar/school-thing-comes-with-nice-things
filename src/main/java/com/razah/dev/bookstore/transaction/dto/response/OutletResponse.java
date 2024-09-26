package com.razah.dev.bookstore.transaction.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OutletResponse {
    private String id;

    private String code;

    private String location;

    private String telephone;

    private String email;
}
