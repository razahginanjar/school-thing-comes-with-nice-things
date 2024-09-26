package com.razah.dev.bookstore.transaction.entity;

import com.razah.dev.bookstore.transaction.constant.BookType;
import com.razah.dev.bookstore.transaction.constant.PhotoMaterials;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m_book")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private BookType type;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product productBook;
}
