package com.app.finanzas.service;

import java.util.List;
import com.app.finanzas.dto.CategoryDTO;

public interface CategoryService {

    CategoryDTO save(CategoryDTO dto);

    CategoryDTO update(Long id, CategoryDTO dto);

    CategoryDTO findById(Long id);

    List<CategoryDTO> findAll();

    boolean delete(Long id);

    boolean existsById(Long id);

    long count();
}
