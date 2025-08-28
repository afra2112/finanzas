package com.app.finanzas.controller;

import com.app.finanzas.dto.UserDTO;
import com.app.finanzas.entity.Transaction;
import com.app.finanzas.entity.User;
import com.app.finanzas.repository.TransactionRepository;
import com.app.finanzas.repository.UserRepository;
import com.app.finanzas.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PaginasController {

    @Autowired
    private UserService usuarioService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("usuario", new User());
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/principal")
    public String paginaPrincipal(HttpSession session, Model model){
        Long idUsuario = (Long) session.getAttribute("idUser");
        UserDTO usuario = usuarioService.findById(idUsuario);
        Double totalIngresos = transactionRepository.obtenerTotalIngresos(idUsuario,"INGRESO");
        Double totalGastos = transactionRepository.obtenerTotalIngresos(idUsuario,"GASTO");
        if(usuario == null){
            return "redirect:/login";
        }
        model.addAttribute("user",usuario);
        List<Transaction> transactions = transactionRepository.getTransactionsById(usuario.getIdUser());
        model.addAttribute("transactions", transactions);
        model.addAttribute("ingresos", totalIngresos);
        model.addAttribute("gastos", totalGastos);
        return "principal";
    }

    @PostMapping("/login")
    public String principal(@ModelAttribute User usuario, HttpSession session, Model model){
        User usuarioBD = userRepository.findByEmail(usuario.getEmail());
        if(usuarioBD != null && usuarioBD.getPassword().equals(usuario.getPassword())){
            session.setAttribute("idUser", usuarioBD.getIdUser());
            return "redirect:/principal";
        }
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getPassword());
        model.addAttribute("fail", true);
        System.out.println("no ingreso");
        return "login";
    }

}
