package com.app.finanzas.dto;

import com.app.finanzas.config.enums.TransactionTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {

    private Long idTransaction;

    private Long idUser;

    private Long idCategory;

    private TransactionTypeEnum type;

    private Double ammount;

    private LocalDateTime date;

    private String description;
}
