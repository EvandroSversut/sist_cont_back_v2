package com.sistema.sistema_contabil.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.sistema_contabil.dto.PessoaJuridicaDTO;
import com.sistema.sistema_contabil.model.PessoaJuridica;
import com.sistema.sistema_contabil.model.Produtos;
import com.sistema.sistema_contabil.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(ProdutoService.class);

       // 🔸 Salvar
    public Produtos salvar(Produtos dto) {
              return repository.save(dto);
        
    }


    // 🔸 Excluir
    public void excluir(Long id) {
        repository.deleteById(id);
    }
    
    // 🔸 Conversor de Entity para DTO
    private PessoaJuridicaDTO converterParaDTO(PessoaJuridica entity) {
        PessoaJuridicaDTO dto = new PessoaJuridicaDTO();
        dto.setId(entity.getId());
        dto.setRazaoSocial(entity.getRazaoSocial());
        dto.setNomeFantasia(entity.getNomeFantasia());
        dto.setCnpj(entity.getCnpj());
        dto.setInscEstadual(entity.getInscEstadual());
        dto.setInscMunicipal(entity.getInscMunicipal());
        dto.setTelefone(entity.getTelefone());
        dto.setEmail(entity.getEmail());
        dto.setRua(entity.getRua());
        dto.setNumero(entity.getNumero());
        dto.setComplemento(entity.getComplemento());
        dto.setBairro(entity.getBairro());
        dto.setCep(entity.getCep());
        dto.setCidade(entity.getCidade());
        dto.setUf(entity.getUf());
        return dto;
    }

    // 🔸 Conversor DTO → Entity
    private PessoaJuridica converterParaEntity(PessoaJuridicaDTO dto) {
        PessoaJuridica entity = new PessoaJuridica();
        //entity.setId(dto.getId());
        entity.setCnpj(dto.getCnpj());
        entity.setRazaoSocial(dto.getRazaoSocial());
        entity.setNomeFantasia(dto.getNomeFantasia());
        entity.setInscEstadual(dto.getInscEstadual());
        entity.setInscMunicipal(dto.getInscMunicipal());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setRua(dto.getRua());
        entity.setNumero(dto.getNumero());
        entity.setComplemento(dto.getComplemento());
        entity.setBairro(dto.getBairro());
        entity.setCep(dto.getCep());
        entity.setCidade(dto.getCidade());
        entity.setUf(dto.getUf());
        return entity;
    }
    
    

}


