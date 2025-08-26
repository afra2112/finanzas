package com.app.finanzas.implement;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.app.finanzas.service.SavingPlanService;
import com.app.finanzas.repository.PlanAhorroRepository;
import com.app.finanzas.dto.SavingPlanDTO;
import com.app.finanzas.entity.SavingPlan;

@Service
public class SavingPlanImplement implements SavingPlanService {

    @Autowired
    private PlanAhorroRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SavingPlanDTO save(SavingPlanDTO dto) {
        SavingPlan entidadSavingPlan = modelMapper.map(dto, SavingPlan.class);
        SavingPlan entidadGuardada = repository.save(entidadSavingPlan);
        return modelMapper.map(entidadGuardada, SavingPlanDTO.class);
    }

    @Override
    public SavingPlanDTO update(Long id, SavingPlanDTO dto) {
        SavingPlan entidadSavingPlan = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("PlanAhorro no encontrado"));

        modelMapper.map(dto, entidadSavingPlan);

        SavingPlan entidadActualizada = repository.save(entidadSavingPlan);
        return modelMapper.map(entidadActualizada, SavingPlanDTO.class);
    }

    @Override
    public SavingPlanDTO findById(Long id) {
        SavingPlan entidadSavingPlan = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("PlanAhorro no encontrado"));
        return modelMapper.map(entidadSavingPlan, SavingPlanDTO.class);
    }

    @Override
    public List<SavingPlanDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> modelMapper.map(entity, SavingPlanDTO.class))
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
