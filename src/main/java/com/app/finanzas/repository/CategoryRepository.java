package com.app.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.finanzas.entity.Categoy;

@Repository
public interface CategoryRepository extends JpaRepository<Categoy, Long> {
}
