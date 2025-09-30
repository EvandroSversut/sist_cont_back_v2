package com.sistema.sistema_contabil.mapper;

import com.sistema.sistema_contabil.dto.NotaFiscalDTO;
import com.sistema.sistema_contabil.model.NotaFiscal;

import java.util.stream.Collectors;

public class NotaFiscalMapper {

    public static NotaFiscal toEntity(NotaFiscalDTO dto) {
        if (dto == null) return null;
        NotaFiscal entity = new NotaFiscal();

        //entity.setId(dto.getId());
        entity.setGeraisNfe(GeraisMapper.toEntity(dto.getGerais()));
        entity.setEmitente(EmitenteMapper.toEntity(dto.getEmitente()));
        entity.setDestinatario(DestinatarioMapper.toEntity(dto.getDestinatario()));
        entity.setTransportadora(TransporteMapper.toEntity(dto.getTransporte()));
        
        if (dto.getProdutos() != null) {
            entity.setItens(dto.getProdutos()
                .stream()
                .map(ProdutoMapper::toEntity)
                .collect(Collectors.toList()));
        }

        return entity;
    }

    public static NotaFiscalDTO toDTO(NotaFiscal entity) {
        if (entity == null) return null;
        NotaFiscalDTO dto = new NotaFiscalDTO();

        //dto.setId(entity.getId());
        dto.setGerais(GeraisMapper.toDTO(entity.getGeraisNfe()));
        dto.setEmitente(EmitenteMapper.toDTO(entity.getEmitente()));
        dto.setDestinatario(DestinatarioMapper.toDTO(entity.getDestinatario()));
        dto.setTransporte(TransporteMapper.toDTO(entity.getTransportadora()));
       // dto.setTotais(TotaisMapper.toDTO(entity.getTotais()));

        if (entity.getItens() != null) {
            dto.setProdutos(entity.getItens()
                .stream()
                .map(ProdutoMapper::toDTO)
                .collect(Collectors.toList()));
        }

        return dto;
    }
}

