package com.app.finanzas.controller;

import com.app.finanzas.dto.SavingPlanDTO;
import com.app.finanzas.service.SavingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SavingPlanController {

    @Autowired
    private SavingPlanService servicePlanAhorro;

   @GetMapping("/ahorros")
    public String ahorros(){
       return "ahorros";
   }
}
