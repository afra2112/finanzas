package com.app.finanzas.controller;

import com.app.finanzas.dto.CapitalizationSettingsDTO;
import com.app.finanzas.service.CapitalizationSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/InteresesCompuestos")
public class CapitalizationSettingsController {

    @Autowired
    private CapitalizationSettingsService serviceConfiguracionInteresCompuesto;

    @GetMapping("/listarTodo")
    public ResponseEntity<List<CapitalizationSettingsDTO>> obtenerTodosLosConfiguracionInteresCompuestos(){
        List<CapitalizationSettingsDTO> entidadesConfiguracionInteresCompuesto = serviceConfiguracionInteresCompuesto.findAll();
        return ResponseEntity.ok(entidadesConfiguracionInteresCompuesto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CapitalizationSettingsDTO> obtenerConfiguracionInteresCompuestoPorId(@PathVariable Long id){
        CapitalizationSettingsDTO dtoConfiguracionInteresCompuesto = serviceConfiguracionInteresCompuesto.findById(id);
        return ResponseEntity.ok(dtoConfiguracionInteresCompuesto);
    }

    @PostMapping("/crearConfiguracionInteresCompuesto")
    public ResponseEntity<CapitalizationSettingsDTO> crearConfiguracionInteresCompuesto(@RequestBody CapitalizationSettingsDTO dtoConfiguracionInteresCompuesto){
        serviceConfiguracionInteresCompuesto.save(dtoConfiguracionInteresCompuesto);
        return ResponseEntity.ok(dtoConfiguracionInteresCompuesto);
    }

    @DeleteMapping("/eliminarConfiguracionInteresCompuesto/{id}")
    public ResponseEntity<Long> eliminarConfiguracionInteresCompuesto(@PathVariable Long id){
        serviceConfiguracionInteresCompuesto.delete(id);
        return ResponseEntity.ok(id);
    }
}
