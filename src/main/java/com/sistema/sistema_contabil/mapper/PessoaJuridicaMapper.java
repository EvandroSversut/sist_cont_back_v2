package com.sistema.sistema_contabil.mapper;

import org.springframework.stereotype.Component;

import com.sistema.sistema_contabil.dto.BrasilApiDTO;
import com.sistema.sistema_contabil.dto.PessoaJuridicaDTO;
import com.sistema.sistema_contabil.model.PessoaJuridica;

@Component
public class PessoaJuridicaMapper {

    // 🔵 ENTITY → DTO
    public PessoaJuridicaDTO toDTO(PessoaJuridica pj) {

        PessoaJuridicaDTO dto = new PessoaJuridicaDTO();

        dto.setId(pj.getId());
        dto.setCnpj(pj.getCnpj());
        dto.setInscEstadual(pj.getIe());
        dto.setRazaoSocial(pj.getRazaoSocial());
        dto.setNomeFantasia(pj.getNomeFantasia());
        dto.setCnae(pj.getCnae());

        dto.setCep(pj.getCep());
        dto.setRua(pj.getRua());
        dto.setNumero(pj.getNumero());
        dto.setBairro(pj.getBairro());
        dto.setCidade(pj.getCidade());
        dto.setUf(pj.getUf());
        dto.setComplemento(pj.getComplemento());

        dto.setTelefone1(pj.getTelefone1());
        dto.setTelefone2(pj.getTelefone2());
        dto.setEmailContato(pj.getEmailContato());
        dto.setIbge(pj.getIbge());

        return dto;
    }

    // 🟢 DTO → ENTITY (IMPORTANTE adicionar)
    public PessoaJuridica toEntity(PessoaJuridicaDTO dto) {

        PessoaJuridica pj = new PessoaJuridica();

        pj.setId(dto.getId());
        pj.setCnpj(dto.getCnpj());
        pj.setIe(dto.getInscEstadual());
        pj.setRazaoSocial(dto.getRazaoSocial());
        pj.setNomeFantasia(dto.getNomeFantasia());
        pj.setCnae(dto.getCnae());

        pj.setCep(dto.getCep());
        pj.setRua(dto.getRua());
        pj.setNumero(dto.getNumero());
        pj.setBairro(dto.getBairro());
        pj.setCidade(dto.getCidade());
        pj.setUf(dto.getUf());
        pj.setComplemento(dto.getComplemento());

        pj.setTelefone1(dto.getTelefone1());
        pj.setTelefone2(dto.getTelefone2());
        pj.setEmailContato(dto.getEmailContato());
        pj.setIbge(dto.getIbge());

        return pj;
    }

    // 🟡 BRASIL API → DTO (PODE FICAR, MAS SEM REGRA)
    public PessoaJuridicaDTO fromBrasilApi(BrasilApiDTO api) {

        PessoaJuridicaDTO dto = new PessoaJuridicaDTO();

        dto.setCnpj(api.getCnpj());
        dto.setRazaoSocial(api.getRazaoSocial());
        dto.setNomeFantasia(api.getNomeFantasia());

        dto.setCep(api.getCep());
        dto.setRua(api.getLogradouro());
        dto.setNumero(api.getNumero());
        dto.setBairro(api.getBairro());
        dto.setCidade(api.getMunicipio());
        dto.setUf(api.getUf());
        dto.setComplemento(api.getComplemento());

        dto.setTelefone1(api.getTelefone1());
        dto.setEmailContato(api.getEmailContato());
        dto.setCnae(api.getCnae());
        dto.setIbge(api.getIbge());

        return dto;
    }
}