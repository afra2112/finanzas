package com.app.finanzas.implement;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.app.finanzas.service.SavingMovementService;
import com.app.finanzas.repository.SavingMovementRepository;
import com.app.finanzas.dto.SavingMovementDTO;
import com.app.finanzas.entity.SavingMovement;

@Service
public class SavingMovementImplement implements SavingMovementService {

    @Autowired
    private SavingMovementRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SavingMovementDTO save(SavingMovementDTO dto) {
        SavingMovement entidadSavingMovement = modelMapper.map(dto, SavingMovement.class);
        SavingMovement entidadGuardada = repository.save(entidadSavingMovement);
        return modelMapper.map(entidadGuardada, SavingMovementDTO.class);
    }

    @Override
    public SavingMovementDTO update(Long id, SavingMovementDTO dto) {
        SavingMovement entidadSavingMovement = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("MovimientoAhorro no encontrado"));

        modelMapper.map(dto, entidadSavingMovement);

        SavingMovement entidadActualizada = repository.save(entidadSavingMovement);
        return modelMapper.map(entidadActualizada, SavingMovementDTO.class);
    }

    @Override
    public SavingMovementDTO findById(Long id) {
        SavingMovement entidadSavingMovement = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("MovimientoAhorro no encontrado"));
        return modelMapper.map(entidadSavingMovement, SavingMovementDTO.class);
    }

    @Override
    public List<SavingMovementDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> modelMapper.map(entity, SavingMovementDTO.class))
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
