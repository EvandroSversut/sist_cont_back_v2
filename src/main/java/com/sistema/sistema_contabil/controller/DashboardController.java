package com.sistema.sistema_contabil.controller;

import com.sistema.sistema_contabil.service.DashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/vendas")
    public Map<String, Object> obterResumoVendas() {
        System.out.println("***********************entrou no dash controller*****************************");
        return dashboardService.obterResumoVendas();
    }
}