package com.razah.dev.bookstore.transaction.entities;

import com.razah.dev.bookstore.transaction.constant.PhotoMaterials;
import com.razah.dev.bookstore.transaction.constant.PhotoSized;
import com.razah.dev.bookstore.transaction.constant.PhotoType;
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

    private PhotoType photoType;

    @Enumerated(EnumType.STRING)
    private PhotoMaterials material;

    @ManyToOne
    @JoinColumn(name = "price_id")
    private PhotoPrice price;

}
