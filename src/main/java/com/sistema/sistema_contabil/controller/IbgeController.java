package com.sistema.sistema_contabil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sistema.sistema_contabil.model.Ibge;
import com.sistema.sistema_contabil.repository.IbgeRepository;



@RestController
@RequestMapping("/api/ibge")
@CrossOrigin(origins = "http://localhost:4200") // ajuste conforme necessário
public class IbgeController {

    @Autowired
    private IbgeRepository ibgeRepository;

    @PostMapping
    public Ibge salvar(@RequestBody Ibge ibge) {
        return ibgeRepository.save(ibge);
    }

    @GetMapping
    public List<Ibge> listar() {
    return ibgeRepository.findAll();
}

}
