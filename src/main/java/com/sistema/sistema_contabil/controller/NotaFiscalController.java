package com.sistema.sistema_contabil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.sistema_contabil.dto.NotaFiscalDTO;
import com.sistema.sistema_contabil.model.PessoaJuridica;
import com.sistema.sistema_contabil.repository.PessoaJuridicaRepository;
import com.sistema.sistema_contabil.service.NotaFiscalService;

@RestController
@RequestMapping("/api/nfe")
@CrossOrigin(origins = "http://localhost:4200")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService notaFiscalService;

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @PostMapping("/json")
    public ResponseEntity<String> salvarNotaJson(@RequestBody NotaFiscalDTO dto) {
        notaFiscalService.salvarNotaFiscalEstruturada(dto);
        return ResponseEntity.ok("NF-e salva com sucesso!");
    }

    @GetMapping("/emitentes")
    public List<PessoaJuridica> buscarEmitentes(@RequestParam String filtro) {
    return pessoaJuridicaRepository.findByCnpjContainingIgnoreCaseOrRazaoSocialContainingIgnoreCase(filtro, filtro);
}

    /* 
    @PostMapping("/json")
    public ResponseEntity<String> salvarNotaJson(@RequestBody NotaFiscalDTO notaFiscalDTO) {
        notaFiscalService.salvarNotaFiscal(notaFiscalDTO);
        return ResponseEntity.ok("NF-e salva com sucesso!");
    }
    */
}
