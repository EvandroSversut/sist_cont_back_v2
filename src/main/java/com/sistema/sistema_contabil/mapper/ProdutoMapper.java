package com.sistema.sistema_contabil.mapper;

import com.sistema.sistema_contabil.dto.ProdutoDTO;
import com.sistema.sistema_contabil.model.ItemNotaFiscal;

public class ProdutoMapper {

    public static ItemNotaFiscal toEntity(ProdutoDTO dto) {
        if (dto == null) return null;
        ItemNotaFiscal entity = new ItemNotaFiscal();

        entity.setCodProd(dto.getCodProd());
        entity.setDescricao(dto.getDescricao());
        entity.setCodBarras(dto.getCodBarras());
        entity.setNcm(dto.getNcm());
        entity.setProdutoST(dto.getProdutoST());
        entity.setCst(dto.getCst());
        entity.setCsosn(dto.getCsosn());
        entity.setCfop(dto.getCfop());
        entity.setUnidade(dto.getUnidade());
        entity.setQuantidade(dto.getQuantidade());
        entity.setValorUnitario(dto.getValorUnitario());
        entity.setDesconto(dto.getDesconto());
        entity.setVrTotalProd(dto.getVrTotalProd());
        entity.setOrigem(dto.getOrigem());
        entity.setBcIcmsProd(dto.getBcIcmsProd());
        entity.setAliqIcms(dto.getAliqIcms());
        entity.setVrDoIcms(dto.getVrDoIcms());
        entity.setStPisCofins(dto.getStPisCofins());
        entity.setBcPisCofins(dto.getBcPisCofins());
        entity.setRegimeApuPisCofins(dto.getRegimeApuPisCofins());
        entity.setVrPis(dto.getVrPis());
        entity.setVrCofins(dto.getVrCofins());
        entity.setStIPI(dto.getStIPI());
        entity.setCodIPI(dto.getCodIPI());
        entity.setAliqIPI(dto.getAliqIPI());
        entity.setVrIPI(dto.getVrIPI());
        entity.setVrTotalServ(dto.getVrTotalServ());
        entity.setBcISSQN(dto.getBcISSQN());
        entity.setVrISSQN(dto.getVrISSQN());
        entity.setRetIRRF(dto.getRetIRRF());
        entity.setRetPisCofins(dto.getRetPisCofins());

        return entity;
    }

    public static ProdutoDTO toDTO(ItemNotaFiscal entity) {
        if (entity == null) return null;

        ProdutoDTO dto = new ProdutoDTO();
        dto.setCodProd(entity.getCodProd());
        dto.setDescricao(entity.getDescricao());
        dto.setCodBarras(entity.getCodBarras());
        dto.setNcm(entity.getNcm());
        dto.setProdutoST(entity.getProdutoST());
        dto.setCst(entity.getCst());
        dto.setCsosn(entity.getCsosn());
        dto.setCfop(entity.getCfop());
        dto.setUnidade(entity.getUnidade());
        dto.setQuantidade(entity.getQuantidade());
        dto.setValorUnitario(entity.getValorUnitario());
        dto.setDesconto(entity.getDesconto());
        dto.setVrTotalProd(entity.getVrTotalProd());
        dto.setOrigem(entity.getOrigem());
        dto.setBcIcmsProd(entity.getBcIcmsProd());
        dto.setAliqIcms(entity.getAliqIcms());
        dto.setVrDoIcms(dto.getVrDoIcms());
        dto.setStPisCofins(entity.getStPisCofins());
        dto.setBcPisCofins(entity.getBcPisCofins());
        dto.setRegimeApuPisCofins(entity.getRegimeApuPisCofins());
        dto.setVrPis(entity.getVrPis());
        dto.setVrCofins(entity.getVrCofins());
        dto.setStIPI(entity.getStIPI());
        dto.setCodIPI(entity.getCodIPI());
        dto.setAliqIPI(entity.getAliqIPI());
        dto.setVrIPI(entity.getVrIPI());
        dto.setVrTotalServ(entity.getVrTotalServ());
        dto.setBcISSQN(entity.getBcISSQN());
        dto.setVrISSQN(entity.getVrISSQN());
        dto.setRetIRRF(entity.getRetIRRF());
        dto.setRetPisCofins(entity.getRetPisCofins());
        return dto;
    }
}
