package com.razah.dev.bookstore.transaction.entities;

import com.razah.dev.bookstore.transaction.constant.ConstantTable;
import com.razah.dev.bookstore.transaction.constant.Roles;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ConstantTable.USERS_ROLES)
@Getter
@Builder
@Setter
public class UsersRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Roles roles;
}
