package com.razah.dev.bookstore.transaction.dto.request;

import com.razah.dev.bookstore.transaction.constant.PhotoMaterials;
import com.razah.dev.bookstore.transaction.constant.PhotoSized;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePhotoRequest {
    private String idOutlet;

    private String id;

    private PhotoSized size;

    private PhotoMaterials material;

    private Integer stock;

    private Long price;
}
