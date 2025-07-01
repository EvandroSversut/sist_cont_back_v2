package com.sistema.sistema_contabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.sistema_contabil.dto.NotaFiscalDTO;
import com.sistema.sistema_contabil.service.NotaFiscalService;

@RestController
@RequestMapping("/api/nfe")
@CrossOrigin(origins = "http://localhost:4200")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService notaFiscalService;

    @PostMapping("/json")
    public ResponseEntity<String> salvarNotaJson(@RequestBody NotaFiscalDTO notaFiscalDTO) {
        notaFiscalService.salvarNotaFiscalEstruturada(notaFiscalDTO);
        return ResponseEntity.ok("Dados da NF-e recebidos e salvos com sucesso!");
    }
}
