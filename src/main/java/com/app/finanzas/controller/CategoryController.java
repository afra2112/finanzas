package com.app.finanzas.controller;

import com.app.finanzas.dto.CategoryDTO;
import com.app.finanzas.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Categorias")
public class CategoryController {

    @Autowired
    private CategoryService serviceCategoria;

    @GetMapping("/listarTodo")
    public ResponseEntity<List<CategoryDTO>> obtenerTodosLosCategorias(){
        List<CategoryDTO> entidadesCategoria = serviceCategoria.findAll();
        return ResponseEntity.ok(entidadesCategoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> obtenerCategoriaPorId(@PathVariable Long id){
        CategoryDTO dtoCategoria = serviceCategoria.findById(id);
        return ResponseEntity.ok(dtoCategoria);
    }

    @PostMapping("/crearCategoria")
    public ResponseEntity<CategoryDTO> crearCategoria(@RequestBody CategoryDTO dtoCategoria){
        serviceCategoria.save(dtoCategoria);
        return ResponseEntity.ok(dtoCategoria);
    }

    @DeleteMapping("/eliminarCategoria/{id}")
    public ResponseEntity<Long> eliminarCategoria(@PathVariable Long id){
        serviceCategoria.delete(id);
        return ResponseEntity.ok(id);
    }
}
