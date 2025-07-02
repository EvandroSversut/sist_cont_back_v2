package com.sistema.sistema_contabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sistema.sistema_contabil.service.NotaFiscalService;

@RestController
@RequestMapping("/api/nfe")
//@CrossOrigin(origins = "*") // libera para o front-end Angular
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class NfeController {

    @Autowired
    private NotaFiscalService service;

    @PostMapping
    public ResponseEntity<String> receberXml(@RequestBody String xml) {

        System.out.println("📄 XML recebido no backend:");
        System.out.println("### tipo do objeto recebido: " + xml.getClass().getName());
        System.out.println("### conteúdo recebido:");
        System.out.println(xml);
        
        //service.salvar(xml);

        return ResponseEntity.ok("XML recebido e salvo com sucesso.");
    }

     // Endpoint para rodar o testeSalvar()
    @GetMapping("/teste-salvar")
    public ResponseEntity<String> testeSalvar() {
        //service.testeSalvar();
        return ResponseEntity.ok("Teste salvar executado.");
    }
}
