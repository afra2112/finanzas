package com.app.finanzas.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "saving_projections")
@Data
public class SavingProjection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjection;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime poyectionDate;

    @Column(nullable = false)
    private Double projectedAmmount;
}