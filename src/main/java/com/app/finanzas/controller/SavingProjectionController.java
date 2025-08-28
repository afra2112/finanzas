package com.app.finanzas.controller;

import com.app.finanzas.dto.SavingProjectionDTO;
import com.app.finanzas.service.SavingProjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ProyeccionesAhorros")
public class SavingProjectionController {

    @Autowired
    private SavingProjectionService serviceProyeccionAhorro;

    @GetMapping("/listarTodo")
    public ResponseEntity<List<SavingProjectionDTO>> obtenerTodosLosProyeccionAhorros(){
        List<SavingProjectionDTO> entidadesProyeccionAhorro = serviceProyeccionAhorro.findAll();
        return ResponseEntity.ok(entidadesProyeccionAhorro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingProjectionDTO> obtenerProyeccionAhorroPorId(@PathVariable Long id){
        SavingProjectionDTO dtoProyeccionAhorro = serviceProyeccionAhorro.findById(id);
        return ResponseEntity.ok(dtoProyeccionAhorro);
    }

    @PostMapping("/crearProyeccionAhorro")
    public ResponseEntity<SavingProjectionDTO> crearProyeccionAhorro(@RequestBody SavingProjectionDTO dtoProyeccionAhorro){
        serviceProyeccionAhorro.save(dtoProyeccionAhorro);
        return ResponseEntity.ok(dtoProyeccionAhorro);
    }

    @DeleteMapping("/eliminarProyeccionAhorro/{id}")
    public ResponseEntity<Long> eliminarProyeccionAhorro(@PathVariable Long id){
        serviceProyeccionAhorro.delete(id);
        return ResponseEntity.ok(id);
    }
}
