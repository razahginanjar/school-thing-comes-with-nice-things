package com.razah.dev.bookstore.transaction.entities;

import com.razah.dev.bookstore.transaction.constant.CheckInStatus;
import com.razah.dev.bookstore.transaction.constant.PhotoType;
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
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String queueId;

    private CheckInStatus status;
}
