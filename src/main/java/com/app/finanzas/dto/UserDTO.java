package com.app.finanzas.dto;

import com.app.finanzas.config.enums.RolEnum;
import lombok.Data;

@Data
public class UserDTO {

    private Long idUser;

    private String name;

    private String email;

    private String password;

    private RolEnum role;

    private Double balance;
}
