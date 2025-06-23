package com.sistema.sistema_contabil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.sistema_contabil.model.Compras;
import com.sistema.sistema_contabil.service.ComprasService;

@RestController
@RequestMapping("/api/compras")
@CrossOrigin(origins = "http://localhost:4200")
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    @PostMapping
    public Compras salvar(@RequestBody Compras compras) {
        return comprasService.salvar(compras);
    }

    @GetMapping
    public List<Compras> listarTodas() {
        return comprasService.listarCompras();
    }

    @GetMapping("/{id}")
    public Compras buscarPorId(@PathVariable Long id) {
        return comprasService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        comprasService.deletar(id);
    }
}
