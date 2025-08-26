package com.app.finanzas.implement;

import com.app.finanzas.service.SavingProjectionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.app.finanzas.repository.SavingProjectionRepository;
import com.app.finanzas.dto.SavingProjectionDTO;
import com.app.finanzas.entity.SavingProjection;

@Service
public class SavingProjectionImplement implements SavingProjectionService {

    @Autowired
    private SavingProjectionRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SavingProjectionDTO save(SavingProjectionDTO dto) {
        SavingProjection entidadSavingProjection = modelMapper.map(dto, SavingProjection.class);
        SavingProjection entidadGuardada = repository.save(entidadSavingProjection);
        return modelMapper.map(entidadGuardada, SavingProjectionDTO.class);
    }

    @Override
    public SavingProjectionDTO update(Long id, SavingProjectionDTO dto) {
        SavingProjection entidadSavingProjection = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("ProyeccionAhorro no encontrado"));

        modelMapper.map(dto, entidadSavingProjection);

        SavingProjection entidadActualizada = repository.save(entidadSavingProjection);
        return modelMapper.map(entidadActualizada, SavingProjectionDTO.class);
    }

    @Override
    public SavingProjectionDTO findById(Long id) {
        SavingProjection entidadSavingProjection = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("ProyeccionAhorro no encontrado"));
        return modelMapper.map(entidadSavingProjection, SavingProjectionDTO.class);
    }

    @Override
    public List<SavingProjectionDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> modelMapper.map(entity, SavingProjectionDTO.class))
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
