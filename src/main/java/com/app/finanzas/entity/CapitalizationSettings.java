package com.app.finanzas.entity;

import com.app.finanzas.config.enums.FrecuenciaInteresEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "capitalization_settings")
@Data
public class CapitalizationSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCapitalizationSettings;

    @ManyToOne
    @JoinColumn(name = "idSavingPlan", nullable = false)
    private SavingPlan savingPlan;

    @Column(nullable = false)
    private FrecuenciaInteresEnum frecuency;

    @Column(nullable = false)
    private Double interestRate;

    @Column(name = "compoundInterest", nullable = false)
    private boolean compoundInterest;
}
