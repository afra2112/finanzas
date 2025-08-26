package com.app.finanzas.implement;

import com.app.finanzas.entity.Transaction;
import com.app.finanzas.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.app.finanzas.repository.TransactionRepository;
import com.app.finanzas.dto.TransactionDTO;

@Service
public class TransactionImplement implements TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TransactionDTO save(TransactionDTO dto) {
        Transaction transactionEntity = modelMapper.map(dto, Transaction.class);
        Transaction savedTransaction = repository.save(transactionEntity);
        return modelMapper.map(savedTransaction, TransactionDTO.class);
    }

    @Override
    public TransactionDTO update(Long id, TransactionDTO dto) {
        Transaction entidadTransaction = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Transaccion no encontrado"));

        modelMapper.map(dto, entidadTransaction);

        Transaction entidadActualizada = repository.save(entidadTransaction);
        return modelMapper.map(entidadActualizada, TransactionDTO.class);
    }

    @Override
    public TransactionDTO findById(Long id) {
        Transaction entidadTransaction = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Transaccion no encontrado"));
        return modelMapper.map(entidadTransaction, TransactionDTO.class);
    }

    @Override
    public List<TransactionDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> modelMapper.map(entity, TransactionDTO.class))
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

    @Override
    public List<TransactionDTO> getTransacctionsByUser(Long idUser) {
        List<Transaction> transactions = repository.findUserById(idUser);

        return transactions.stream()
                .map(t -> modelMapper.map(transactions, TransactionDTO.class))
                .collect(Collectors.toList());
    }
}
