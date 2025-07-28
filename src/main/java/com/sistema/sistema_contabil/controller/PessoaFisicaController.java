package com.sistema.sistema_contabil.controller;

import com.sistema.sistema_contabil.generics.BaseController;
import com.sistema.sistema_contabil.mapper.PessoaFisicaMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.sistema_contabil.model.PessoaFisica;
import com.sistema.sistema_contabil.service.PessoaFisicaService;

@RestController
@RequestMapping("/api/pessoas-fisicas")
@Tag(name = "Pessoas Físicas", description = "API para gerenciamento de pessoas físicas")
public class PessoaFisicaController extends BaseController<PessoaFisica, Long> {

    private final PessoaFisicaService pessoaFisicaService;
    private final PessoaFisicaMapper pessoaFisicaMapper;

    // Injeta o serviço específico e passa para o controller base
    public PessoaFisicaController(PessoaFisicaService pessoaFisicaService, PessoaFisicaMapper pessoaFisicaMapper) {
        super(pessoaFisicaService);
        this.pessoaFisicaService = pessoaFisicaService;
        this.pessoaFisicaMapper = pessoaFisicaMapper;

    }

    @GetMapping("/buscar")
    @Operation(summary = "Busca uma pessoa física pelo CPF")
    public ResponseEntity<PessoaFisica> buscarPorCpf(@RequestParam String cpf) {
        return pessoaFisicaService.buscarPorCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
