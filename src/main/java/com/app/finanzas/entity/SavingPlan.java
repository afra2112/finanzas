package com.app.finanzas.entity;


import com.app.finanzas.config.enums.EstadoPlanAhorroEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "saving_plans")
@Data
public class SavingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSavingPlan;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @Column(nullable = false, length = 100)
    private String savingPlanName;

    @Column(nullable = false)
    private Double savingGoal;

    @Column(nullable = false)
    private LocalDate savingGoalDate;

    @Column(nullable = false)
    private Double currentAmmount = 0.0;

    @Column(nullable = false)
    private SavingPlanStatusEnum savingStatus;
}