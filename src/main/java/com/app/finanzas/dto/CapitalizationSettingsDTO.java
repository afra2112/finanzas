package com.app.finanzas.dto;

import com.app.finanzas.config.enums.InterestFrecuencyEnum;
import lombok.Data;

@Data
public class CapitalizationSettingsDTO {

    private Long idCapitalizationSettings;

    private Long idSavingPlan;

    private InterestFrecuencyEnum frecuency;

    private Double interestRate;

    private boolean compoundInterest;
}
