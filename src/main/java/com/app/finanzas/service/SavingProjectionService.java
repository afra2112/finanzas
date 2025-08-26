package com.app.finanzas.service;

import java.util.List;
import com.app.finanzas.dto.SavingProjectionDTO;

public interface SavingProjectionService {

    SavingProjectionDTO save(SavingProjectionDTO dto);

    SavingProjectionDTO update(Long id, SavingProjectionDTO dto);

    SavingProjectionDTO findById(Long id);

    List<SavingProjectionDTO> findAll();

    boolean delete(Long id);

    boolean existsById(Long id);

    long count();
}
