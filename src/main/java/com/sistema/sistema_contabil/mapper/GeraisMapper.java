package com.sistema.sistema_contabil.mapper;

import com.sistema.sistema_contabil.dto.GeraisDTO;
import com.sistema.sistema_contabil.model.GeraisNfe;

public class GeraisMapper {

    public static GeraisNfe toEntity(GeraisDTO dto) {
        if (dto == null) return null;

        GeraisNfe entity = new GeraisNfe();
        entity.setLayout(dto.getLayout());
        entity.setIdChaveAcesso(dto.getIdChaveAcesso());
        entity.setUfEmitente(dto.getUfEmitente());
        entity.setNatOperacao(dto.getNatOperacao());
        entity.setCrt(dto.getCrt());
        entity.setSerie(dto.getSerie());
        entity.setNumeroNFe(dto.getNumeroNFe());
        entity.setDtHrEmissao(dto.getDtHrEmissao());
        entity.setDtHrSaida(dto.getDtHrSaida());
        entity.setTipo(dto.getTipo());
        entity.setDestinoOpe(dto.getDestinoOpe());
        entity.setIbge(dto.getIbge());
        entity.setFormatoDanfe(dto.getFormatoDanfe());
        entity.setTipoEmissao(dto.getTipoEmissao());
        entity.setDigitoChave(dto.getDigitoChave());
        entity.setAmbiente(dto.getAmbiente());
        entity.setFinalidade(dto.getFinalidade());
        entity.setConsumidorFinal(dto.getConsumidorFinal());
        entity.setVendaPresencial(dto.getVendaPresencial());
        entity.setCodNumericoNFe(dto.getCodNumericoNFe());
        entity.setProcessoVersaoEmissor(dto.getProcessoVersaoEmissor());
        entity.setBaseCalculo(dto.getBaseCalculo());
        entity.setVrIcms(dto.getVrIcms());
        entity.setVrTotalProd(dto.getVrTotalProd());
        entity.setVrTotalNfe(dto.getVrTotalNfe());
       
        return entity;
    }

    public static GeraisDTO toDTO(GeraisNfe entity) {
        if (entity == null) return null;

        GeraisDTO dto = new GeraisDTO();
        dto.setLayout(entity.getLayout());
        dto.setIdChaveAcesso(entity.getIdChaveAcesso());
        dto.setUfEmitente(entity.getUfEmitente());
        dto.setCodNumericoNFe(entity.getCodNumericoNFe());
        dto.setNatOperacao(entity.getNatOperacao());
        dto.setCrt(entity.getCrt());
        dto.setSerie(entity.getSerie());
        dto.setNumeroNFe(entity.getNumeroNFe());
        dto.setDtHrEmissao(entity.getDtHrEmissao());
        dto.setDtHrSaida(entity.getDtHrSaida());
        dto.setTipo(entity.getTipo());
        dto.setTipoEmissao(entity.getTipoEmissao());
        dto.setDestinoOpe(entity.getDestinoOpe());
        dto.setIbge(entity.getIbge());
        dto.setFormatoDanfe(entity.getFormatoDanfe());
        dto.setDigitoChave(entity.getDigitoChave());
        dto.setAmbiente(entity.getAmbiente());
        dto.setFinalidade(entity.getFinalidade());
        dto.setConsumidorFinal(entity.getConsumidorFinal());
        dto.setVendaPresencial(entity.getVendaPresencial());
        dto.setProcessoVersaoEmissor(entity.getProcessoVersaoEmissor());
        dto.setBaseCalculo(entity.getBaseCalculo());
        dto.setVrIcms(entity.getVrIcms());
        dto.setVrTotalProd(entity.getVrTotalProd());
        dto.setVrTotalNfe(entity.getVrTotalNfe());

        return dto;
    }
}
