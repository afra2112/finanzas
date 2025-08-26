package com.app.finanzas.controller;

import com.app.finanzas.dto.UserDTO;
import com.app.finanzas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Usuarios")
public class UserController {

    @Autowired
    private UserService serviceUsuario;

    @GetMapping("/listarTodo")
    public ResponseEntity<List<UserDTO>> obtenerTodosLosUsuarios(){
        List<UserDTO> entidadesUsuario = serviceUsuario.findAll();
        return ResponseEntity.ok(entidadesUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> obtenerUsuarioPorId(@PathVariable Long id){
        UserDTO dtoUsuario = serviceUsuario.findById(id);
        return ResponseEntity.ok(dtoUsuario);
    }

    @PostMapping("/crearUsuario")
    public ResponseEntity<UserDTO> crearUsuario(@RequestBody UserDTO dtoUsuario){
        serviceUsuario.save(dtoUsuario);
        return ResponseEntity.ok(dtoUsuario);
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public ResponseEntity<Long> eliminarUsuario(@PathVariable Long id){
        serviceUsuario.delete(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/actualizarUsuario/{id}")
    public ResponseEntity<UserDTO> actualizarUsuario(@PathVariable Long id, @RequestBody UserDTO dtoUsuario){
        UserDTO usuarioActualizado = serviceUsuario.update(id, dtoUsuario);
        return ResponseEntity.ok(usuarioActualizado);
    }
}
