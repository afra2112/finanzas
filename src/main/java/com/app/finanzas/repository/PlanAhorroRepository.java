package com.app.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.finanzas.entity.SavingPlan;

@Repository
public interface PlanAhorroRepository extends JpaRepository<SavingPlan, Long> {
}
