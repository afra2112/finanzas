package com.app.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.finanzas.entity.CapitalizationSettings;

@Repository
public interface CapitalizationSettingsRepository extends JpaRepository<CapitalizationSettings, Long> {
}
