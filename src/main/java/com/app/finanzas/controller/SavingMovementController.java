package com.app.finanzas.controller;

import com.app.finanzas.dto.SavingMovementDTO;
import com.app.finanzas.service.SavingMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/MovimientosAhorros")
public class SavingMovementController {

    @Autowired
    private SavingMovementService serviceMovimientoAhorro;

    @GetMapping("/listarTodo")
    public ResponseEntity<List<SavingMovementDTO>> obtenerTodosLosMovimientoAhorros(){
        List<SavingMovementDTO> entidadesMovimientoAhorro = serviceMovimientoAhorro.findAll();
        return ResponseEntity.ok(entidadesMovimientoAhorro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingMovementDTO> obtenerMovimientoAhorroPorId(@PathVariable Long id){
        SavingMovementDTO dtoMovimientoAhorro = serviceMovimientoAhorro.findById(id);
        return ResponseEntity.ok(dtoMovimientoAhorro);
    }

    @PostMapping("/crearMovimientoAhorro")
    public ResponseEntity<SavingMovementDTO> crearMovimientoAhorro(@RequestBody SavingMovementDTO dtoMovimientoAhorro){
        serviceMovimientoAhorro.save(dtoMovimientoAhorro);
        return ResponseEntity.ok(dtoMovimientoAhorro);
    }

    @DeleteMapping("/eliminarMovimientoAhorro/{id}")
    public ResponseEntity<Long> eliminarMovimientoAhorro(@PathVariable Long id){
        serviceMovimientoAhorro.delete(id);
        return ResponseEntity.ok(id);
    }
}
