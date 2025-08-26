package com.app.finanzas.service;

import java.util.List;
import com.app.finanzas.dto.SavingPlanDTO;

public interface SavingPlanService {

    SavingPlanDTO save(SavingPlanDTO dto);

    SavingPlanDTO update(Long id, SavingPlanDTO dto);

    SavingPlanDTO findById(Long id);

    List<SavingPlanDTO> findAll();

    boolean delete(Long id);

    boolean existsById(Long id);

    long count();
}
