package com.app.finanzas.implement;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.app.finanzas.service.CapitalizationSettingsService;
import com.app.finanzas.repository.CapitalizationSettingsRepository;
import com.app.finanzas.dto.CapitalizationSettingsDTO;
import com.app.finanzas.entity.CapitalizationSettings;

@Service
public class CapitalizationSettingsImplement implements CapitalizationSettingsService {

    @Autowired
    private CapitalizationSettingsRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CapitalizationSettingsDTO save(CapitalizationSettingsDTO dto) {
        CapitalizationSettings entidadCapitalizationSettings = modelMapper.map(dto, CapitalizationSettings.class);
        CapitalizationSettings entidadGuardada = repository.save(entidadCapitalizationSettings);
        return modelMapper.map(entidadGuardada, CapitalizationSettingsDTO.class);
    }

    @Override
    public CapitalizationSettingsDTO update(Long id, CapitalizationSettingsDTO dto) {
        CapitalizationSettings entidadCapitalizationSettings = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("ConfiguracionInteresCompuesto no encontrado"));

        modelMapper.map(dto, entidadCapitalizationSettings);

        CapitalizationSettings entidadActualizada = repository.save(entidadCapitalizationSettings);
        return modelMapper.map(entidadActualizada, CapitalizationSettingsDTO.class);
    }

    @Override
    public CapitalizationSettingsDTO findById(Long id) {
        CapitalizationSettings entidadCapitalizationSettings = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("ConfiguracionInteresCompuesto no encontrado"));
        return modelMapper.map(entidadCapitalizationSettings, CapitalizationSettingsDTO.class);
    }

    @Override
    public List<CapitalizationSettingsDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> modelMapper.map(entity, CapitalizationSettingsDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        if(!repository.existsById(id)){
               return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }
}
