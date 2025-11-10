package com.sistema.sistema_contabil.service;


import com.sistema.sistema_contabil.model.NotaFiscal;
import com.sistema.sistema_contabil.repository.NotaFiscalRepository;
import com.sistema.sistema_contabil.repository.PessoaJuridicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DashboardService {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public Map<String, Object> obterResumoVendas() {
        Map<String, Object> dados = new HashMap<>();

        Double totalVendas = notaFiscalRepository.somarTotalVendas();
        System.out.println("TOTAL VENDAS-------------->>>>>>> " + totalVendas);

        Long totalNotas = notaFiscalRepository.contarNotasEmitidas();
        System.out.println("TOTAL NOTAS-------------->>>>>>> " + totalNotas);

        Long totalClientes = pessoaJuridicaRepository.contarClientes();
        System.out.println("TOTAL DE CLIENTES-------------->>>>>>> " + totalClientes);

        dados.put("totalVendas", totalVendas != null ? totalVendas : 0.0);
        dados.put("totalNotas", totalNotas != null ? totalNotas : 0L);
        dados.put("totalClientes", totalClientes != null ? totalClientes : 0L);

        return dados;
    }
}