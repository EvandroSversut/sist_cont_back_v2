package com.sistema.sistema_contabil.controller;

import com.sistema.sistema_contabil.dto.NotaFiscalDTO;
import com.sistema.sistema_contabil.dto.NotaFiscalResumoDTO;
import com.sistema.sistema_contabil.service.NotaFiscalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nfe")
@CrossOrigin(origins = "http://localhost:4200")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService notaFiscalService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvarNotaFiscal(@RequestBody NotaFiscalDTO dto) {
        notaFiscalService.salvarNotaFiscalEstruturada(dto);
        return ResponseEntity.ok("NF-e salva com sucesso!");
    }

    /* 
    @PostMapping("/json")
    public ResponseEntity<String> salvarNotaJson(@RequestBody NotaFiscalDTO notaFiscalDTO) {
        notaFiscalService.salvarNotaFiscal(notaFiscalDTO);
        return ResponseEntity.ok("NF-e salva com sucesso!");
    }
    */
    @GetMapping("/listar")
    public List<NotaFiscalResumoDTO> listarNotas() {
        return notaFiscalService.listarNotas();
    }

}
