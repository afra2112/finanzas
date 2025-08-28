package com.app.finanzas.service;

import java.util.List;
import com.app.finanzas.dto.TransactionDTO;

public interface TransactionService {

    TransactionDTO save(TransactionDTO dto);

    TransactionDTO update(Long id, TransactionDTO dto);

    TransactionDTO findById(Long id);

    List<TransactionDTO> findAll();

    boolean delete(Long id);

    boolean existsById(Long id);

    long count();
}
