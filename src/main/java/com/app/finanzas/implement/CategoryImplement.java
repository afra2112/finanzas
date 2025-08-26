package com.app.finanzas.implement;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.app.finanzas.service.CategoryService;
import com.app.finanzas.repository.CategoryRepository;
import com.app.finanzas.dto.CategoryDTO;
import com.app.finanzas.entity.Categoy;

@Service
public class CategoryImplement implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        Categoy entidadCategoria = modelMapper.map(dto, Categoy.class);
        Categoy entidadGuardada = repository.save(entidadCategoria);
        return modelMapper.map(entidadGuardada, CategoryDTO.class);
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO dto) {
        Categoy entidadCategoria = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Categoria no encontrado"));

        modelMapper.map(dto, entidadCategoria);

        Categoy entidadActualizada = repository.save(entidadCategoria);
        return modelMapper.map(entidadActualizada, CategoryDTO.class);
    }

    @Override
    public CategoryDTO findById(Long id) {
        Categoy entidadCategoria = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Categoria no encontrado"));
        return modelMapper.map(entidadCategoria, CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> modelMapper.map(entity, CategoryDTO.class))
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
