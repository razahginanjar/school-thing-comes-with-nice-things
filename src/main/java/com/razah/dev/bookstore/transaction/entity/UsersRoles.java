package com.razah.dev.bookstore.transaction.entity;

import com.razah.dev.bookstore.transaction.constant.ConstantTable;
import com.razah.dev.bookstore.transaction.constant.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ConstantTable.USERS_ROLES)
@Getter
@Setter
public class UsersRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Roles roles;
}
