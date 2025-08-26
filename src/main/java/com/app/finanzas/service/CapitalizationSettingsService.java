package com.app.finanzas.service;

import java.util.List;
import com.app.finanzas.dto.CapitalizationSettingsDTO;

public interface CapitalizationSettingsService {

    CapitalizationSettingsDTO save(CapitalizationSettingsDTO dto);

    CapitalizationSettingsDTO update(Long id, CapitalizationSettingsDTO dto);

    CapitalizationSettingsDTO findById(Long id);

    List<CapitalizationSettingsDTO> findAll();

    boolean delete(Long id);

    boolean existsById(Long id);

    long count();
}
