package com.app.finanzas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categorys")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    @Column(name = "categoryName", nullable = false, length = 20)
    private String categoryName;

    @Column(name = "description", nullable = true)
    private String description;
}
