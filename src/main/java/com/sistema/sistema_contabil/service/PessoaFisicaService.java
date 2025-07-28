package com.sistema.sistema_contabil.service;

// PessoaFisicaService: responsável por cadastrar e consultar pessoas físicas.

import java.util.List;
import java.util.Optional;

import com.sistema.sistema_contabil.generics.BaseService;
import com.sistema.sistema_contabil.generics.BaseServiceImpl;
import org.springframework.stereotype.Service;

import com.sistema.sistema_contabil.model.PessoaFisica;
import com.sistema.sistema_contabil.repository.PessoaFisicaRepository;


@Service
public class PessoaFisicaService extends BaseServiceImpl<PessoaFisica, Long, PessoaFisicaRepository> {

    public PessoaFisicaService(PessoaFisicaRepository pessoaFisicaRepository) {
        super(pessoaFisicaRepository);
    }

    // Busca por CPF
    public Optional<PessoaFisica> buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf);
    }


}
