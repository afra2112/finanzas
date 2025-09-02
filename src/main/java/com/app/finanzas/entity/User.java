package com.app.finanzas.entity;

import com.app.finanzas.config.enums.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
}
