package com.sistema.sistema_contabil.mapper;

import com.sistema.sistema_contabil.dto.PessoaFisicaDTO;
import com.sistema.sistema_contabil.generics.BaseMapper;
import com.sistema.sistema_contabil.model.PessoaFisica;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
// A classe agora implementa nosso contrato genérico
public interface PessoaFisicaMapper extends BaseMapper<PessoaFisicaDTO, PessoaFisica> {

    // O MapStruct vai gerar a implementação para os métodos da interface BaseMapper.
    // Não precisamos redeclará-los aqui se os nomes forem os mesmos.

    // No entanto, ainda precisamos de métodos específicos como o de atualização.
    void updateEntityFromDto(PessoaFisicaDTO dto, @MappingTarget PessoaFisica entity);
}

