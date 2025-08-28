package com.app.finanzas.repository;

import com.app.finanzas.dto.TransactionDTO;
import com.app.finanzas.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT * FROM transactions WHERE id_user = :idUser", nativeQuery = true)
    List<Transaction> getTransactionsById(@Param("idUser") Long idUser);
}
