package com.razah.dev.bookstore.transaction.dto.request;

import com.razah.dev.bookstore.transaction.constant.PhotoMaterials;
import com.razah.dev.bookstore.transaction.constant.PhotoSized;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePhotoRequest {
    private String idOutlet;

    private PhotoSized size;

    private Integer stock;

    private PhotoMaterials material;

    private Long price;
}
