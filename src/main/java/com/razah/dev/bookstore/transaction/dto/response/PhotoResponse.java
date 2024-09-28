package com.razah.dev.bookstore.transaction.dto.response;

import com.razah.dev.bookstore.transaction.constant.PhotoMaterials;
import com.razah.dev.bookstore.transaction.constant.PhotoSized;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhotoResponse {

    private String id;

    private PhotoSized size;

    private PhotoMaterials material;

    private ProductResponse product;
}
