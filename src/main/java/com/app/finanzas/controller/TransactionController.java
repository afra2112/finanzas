package com.app.finanzas.controller;

import com.app.finanzas.dto.TransactionDTO;
import com.app.finanzas.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Transacciones")
public class TransactionController {

    @Autowired
    private TransactionService serviceTransaccion;

    @GetMapping("/listarTodo")
    public ResponseEntity<List<TransactionDTO>> obtenerTodosLosTransaccions(){
        List<TransactionDTO> entidadesTransaccion = serviceTransaccion.findAll();
        return ResponseEntity.ok(entidadesTransaccion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> obtenerTransaccionPorId(@PathVariable Long id){
        TransactionDTO dtoTransaccion = serviceTransaccion.findById(id);
        return ResponseEntity.ok(dtoTransaccion);
    }

    @PostMapping("/crearTransaccion")
    public ResponseEntity<TransactionDTO> crearTransaccion(@RequestBody TransactionDTO dtoTransaccion){
        serviceTransaccion.save(dtoTransaccion);
        return ResponseEntity.ok(dtoTransaccion);
    }

    @DeleteMapping("/eliminarTransaccion/{id}")
    public ResponseEntity<Long> eliminarTransaccion(@PathVariable Long id){
        serviceTransaccion.delete(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/Usuarios/{idUsuario}")
    public ResponseEntity<List<TransactionDTO>> obtenerTransaccionesPorIdUsuario(@PathVariable Long idUsuario) {
        List<TransactionDTO> transaccionesUsuario = serviceTransaccion.getTransacctionsByUser(idUsuario);
        return ResponseEntity.ok(transaccionesUsuario);
    }
}
