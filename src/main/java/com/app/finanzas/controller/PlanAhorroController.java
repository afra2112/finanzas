package com.app.finanzas.controller;

import com.app.finanzas.dto.SavingPlanDTO;
import com.app.finanzas.service.SavingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/PlanesAhorros")
public class PlanAhorroController {

    @Autowired
    private SavingPlanService servicePlanAhorro;

    @GetMapping("/listarTodo")
    public ResponseEntity<List<SavingPlanDTO>> obtenerTodosLosPlanAhorros(){
        List<SavingPlanDTO> entidadesPlanAhorro = servicePlanAhorro.findAll();
        return ResponseEntity.ok(entidadesPlanAhorro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingPlanDTO> obtenerPlanAhorroPorId(@PathVariable Long id){
        SavingPlanDTO dtoPlanAhorro = servicePlanAhorro.findById(id);
        return ResponseEntity.ok(dtoPlanAhorro);
    }

    @PostMapping("/crearPlanAhorro")
    public ResponseEntity<SavingPlanDTO> crearPlanAhorro(@RequestBody SavingPlanDTO dtoPlanAhorro){
        servicePlanAhorro.save(dtoPlanAhorro);
        return ResponseEntity.ok(dtoPlanAhorro);
    }

    @DeleteMapping("/eliminarPlanAhorro/{id}")
    public ResponseEntity<Long> eliminarPlanAhorro(@PathVariable Long id){
        servicePlanAhorro.delete(id);
        return ResponseEntity.ok(id);
    }
}
