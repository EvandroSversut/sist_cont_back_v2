package com.sistema.sistema_contabil.mapper;

import com.sistema.sistema_contabil.dto.PessoaJuridicaDTO;
import com.sistema.sistema_contabil.model.PessoaJuridica;

public class DestinatarioMapper {

    public static PessoaJuridica toEntity(PessoaJuridicaDTO dto) {
        if (dto == null) return null;

        PessoaJuridica entity = new PessoaJuridica();
        entity.setRazaoSocial(dto.getRazaoSocial());
        
       
        return entity;
    }

    public static PessoaJuridicaDTO toDTO(PessoaJuridica entity) {
        if (entity == null) return null;

        PessoaJuridicaDTO dto = new PessoaJuridicaDTO();
        dto.setRazaoSocial(entity.getRazaoSocial());
       

        return dto;
    }
}
