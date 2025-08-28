package com.app.finanzas.service;

import java.util.List;
import com.app.finanzas.dto.UserDTO;

public interface UserService {

    UserDTO save(UserDTO dto);

    UserDTO update(Long id, UserDTO dto);

    UserDTO findById(Long id);

    List<UserDTO> findAll();

    boolean delete(Long id);

    boolean existsById(Long id);

    long count();

    boolean validarLogin(String email, String contrasena);
}
