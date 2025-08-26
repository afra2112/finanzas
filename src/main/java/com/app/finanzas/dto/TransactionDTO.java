package com.app.finanzas.dto;

import com.app.finanzas.config.enums.TipoTransaccionEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {

    private Long idTransaction;

    private Long idUser;

    private Long idCategory;

    private TipoTransaccionEnum type;

    private Double ammount;

    private LocalDateTime date;

    private String description;
}
