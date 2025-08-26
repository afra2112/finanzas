package com.app.finanzas.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SavingProjectionDTO {

    private Long idProjection;

    private Long idUser;

    private LocalDateTime projectionDate;

    private Double projectedAmmount;
}