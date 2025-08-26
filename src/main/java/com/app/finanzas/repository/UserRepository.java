package com.app.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.finanzas.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
