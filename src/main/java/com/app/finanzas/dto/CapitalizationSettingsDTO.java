package com.app.finanzas.dto;

import com.app.finanzas.config.enums.FrecuenciaInteresEnum;
import lombok.Data;

@Data
public class CapitalizationSettingsDTO {

    private Long idCapitalizationSettings;

    private Long idSavingPlan;

    private FrecuenciaInteresEnum frecuency;

    private Double interestRate;

    private boolean compoundInterest;
}
