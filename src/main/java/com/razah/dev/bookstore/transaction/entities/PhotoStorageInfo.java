package com.razah.dev.bookstore.transaction.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhotoStorageInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "info_id")
    private String infoId;

    private String url;

    @OneToOne
    @JoinColumn(name = "queue_id")
    private Queue queue;


}
