package com.app.finanzas.controller;

import com.app.finanzas.dto.CategoryDTO;
import com.app.finanzas.dto.TransactionDTO;
import com.app.finanzas.entity.Transaction;
import com.app.finanzas.repository.TransactionRepository;
import com.app.finanzas.service.CategoryService;
import com.app.finanzas.service.TransactionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/transacciones")
public class TransactionController {

    @Autowired
    private TransactionService serviceTransaccion;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TransactionRepository repositoryTransaction;

    @GetMapping("/listar")
    public String listarTransacciones(HttpSession session, Model model){
        Long idUsuario = (Long) session.getAttribute("idUser");
        List<Transaction> listaTransacciones = repositoryTransaction.getTransactionsById(idUsuario);
        List<CategoryDTO> categorias = categoryService.findAll();
        model.addAttribute("transaccionDTO", new TransactionDTO());
        model.addAttribute("transacciones", listaTransacciones);
        model.addAttribute("nombresCategorias", categorias);
        return "transacciones";
    }

    @PostMapping("/crear")
    public String crearTransaccion(@ModelAttribute("transaccionDTO") TransactionDTO transactionDTO, HttpSession session){
        LocalDateTime fechaActual = LocalDateTime.now();
        Long idUser = (Long) session.getAttribute("idUser");
        transactionDTO.setIdUser(idUser);
        transactionDTO.setDate(fechaActual);
        serviceTransaccion.save(transactionDTO);
        return "redirect:/transacciones/listar";
    }
}
