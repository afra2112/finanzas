package com.app.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.finanzas.entity.SavingProjection;

@Repository
public interface SavingProjectionRepository extends JpaRepository<SavingProjection, Long> {
}
