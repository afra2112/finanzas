package com.app.finanzas.service;

import java.util.List;
import com.app.finanzas.dto.SavingMovementDTO;

public interface SavingMovementService {

    SavingMovementDTO save(SavingMovementDTO dto);

    SavingMovementDTO update(Long id, SavingMovementDTO dto);

    SavingMovementDTO findById(Long id);

    List<SavingMovementDTO> findAll();

    boolean delete(Long id);

    boolean existsById(Long id);

    long count();
}
