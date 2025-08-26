package com.app.finanzas.entity;

import com.app.finanzas.config.enums.RolEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser", nullable = false, unique = true)
    private Long idUser;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private RoleEnum role;

    @Column(name = "balance", nullable = false)
    private Double balance = 0.0;
}
