package com.sistema.sistema_contabil.mapper;

import com.sistema.sistema_contabil.dto.TransporteDTO;
import com.sistema.sistema_contabil.model.Transporte;

public class TransporteMapper {

    public static Transporte toEntity(TransporteDTO dto) {
        if (dto == null) return null;

        Transporte entity = new Transporte();

        entity.setModFrete(dto.getModFrete());
        entity.setTransportadora(dto.getTransportadora());
        entity.setCnpjTransportadora(dto.getCnpjTransportadora());
        entity.setPlacaVeiculo(dto.getPlacaVeiculo());
        entity.setUfPlaca(dto.getUfPlaca());
       
        return entity;
    }

    public static TransporteDTO toDTO(Transporte entity) {
        if (entity == null) return null;

        TransporteDTO dto = new TransporteDTO();
        
        dto.setModFrete(entity.getModFrete());
        dto.setTransportadora(entity.getTransportadora());
        dto.setCnpjTransportadora(entity.getCnpjTransportadora());
        dto.setPlacaVeiculo(entity.getPlacaVeiculo());
        dto.setUfPlaca(entity.getUfPlaca());

        return dto;
    }
}
