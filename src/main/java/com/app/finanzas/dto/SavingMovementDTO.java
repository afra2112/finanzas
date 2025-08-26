package com.app.finanzas.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SavingMovementDTO {

    private Long idSavingMovement;

    private Long idSavingPlan;

    private Double ammount;

    private LocalDate date;

    private String description;
}
