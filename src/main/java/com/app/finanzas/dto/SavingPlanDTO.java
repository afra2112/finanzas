package com.app.finanzas.dto;


import com.app.finanzas.config.enums.EstadoPlanAhorroEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SavingPlanDTO {

    private Long idSavingPlan;

    private Long idUser;

    private String savingPlanName;

    private Double savingGoal;

    private LocalDate savingGoalDate;

    private Double currentAmmount;

    private EstadoPlanAhorroEnum savingStatus;
}