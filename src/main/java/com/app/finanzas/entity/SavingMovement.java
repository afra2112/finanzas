package com.app.finanzas.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "saving_movements")
@Data
public class SavingMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSavingMovement;

    @ManyToOne
    @JoinColumn(name = "idSavingPlan", nullable = false)
    private SavingPlan savingPlan;

    @Column(nullable = false)
    private Double ammount;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false, length = 255)
    private String description;
}
