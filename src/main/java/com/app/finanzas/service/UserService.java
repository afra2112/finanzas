package com.app.finanzas.service;

import java.util.List;
import com.app.finanzas.dto.UserDTO;
import com.app.finanzas.entity.User;

public interface UserService {

    void save(User usuario);

    UserDTO update(Long id, UserDTO dto);

    UserDTO findById(Long id);

    List<UserDTO> findAll();

    boolean delete(Long id);

    boolean existsById(Long id);

    long count();

    boolean validarLogin(String email, String contrasena);
}
