package com.razah.dev.bookstore.transaction.entity;

import com.razah.dev.bookstore.transaction.constant.ConstantTable;
import com.razah.dev.bookstore.transaction.constant.PhotoMaterials;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m_photo")
@Getter
@Setter
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String size;

    @Enumerated(EnumType.STRING)
    private PhotoMaterials material;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product productPhoto;

}
