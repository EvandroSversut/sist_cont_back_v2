package com.sistema.sistema_contabil.dto;

import java.math.BigDecimal;

public class ProdutoDTO {
    
    private String codProd;
    private String descricao;
    private String codBarras;
    private String ncm;
    private String produtoST;
    private String cst;
    private String csosn;
    private String cfop;
    private String unidade;
    private BigDecimal quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal desconto;
    private BigDecimal vrTotalProd;
    private String origem;
    private BigDecimal bcIcmsProd;
    private BigDecimal aliqIcms;
    private BigDecimal vrDoIcms;
    private BigDecimal stPisCofins;
    private BigDecimal bcPisCofins;
    private String regimeApuPisCofins;
    private BigDecimal vrPis;
    private BigDecimal vrCofins;
    private String stIPI;
    private String codIPI;
    private BigDecimal aliqIPI;
    private BigDecimal vrIPI;
    private BigDecimal vrTotalServ;
    private BigDecimal bcISSQN;
    private BigDecimal vrISSQN;
    private BigDecimal retIRRF;
    private BigDecimal retPisCofins;

     public String getCodProd() {
        return codProd;
    }
    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }


    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getCodBarras() {
        return codBarras;
    }
    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }
    public String getNcm() {
        return ncm;
    }
    public void setNcm(String ncm) {
        this.ncm = ncm;
    }
    public String getProdutoST() {
        return produtoST;
    }
    public void setProdutoST(String produtoST) {
        this.produtoST = produtoST;
    }
    public String getCst() {
        return cst;
    }
    public void setCst(String cst) {
        this.cst = cst;
    }
    public String getCsosn() {
        return csosn;
    }
    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }
    public String getCfop() {
        return cfop;
    }
    public void setCfop(String cfop) {
        this.cfop = cfop;
    }
    public String getUnidade() {
        return unidade;
    }
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    public BigDecimal getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public BigDecimal getDesconto() {
        return desconto;
    }
    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }
    public BigDecimal getVrTotalProd() {
        return vrTotalProd;
    }
    public void setVrTotalProd(BigDecimal vrTotalProd) {
        this.vrTotalProd = vrTotalProd;
    }
    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public BigDecimal getBcIcmsProd() {
        return bcIcmsProd;
    }
    public void setBcIcmsProd(BigDecimal bcIcmsProd) {
        this.bcIcmsProd = bcIcmsProd;
    }
    public BigDecimal getAliqIcms() {
        return aliqIcms;
    }
    public void setAliqIcms(BigDecimal aliqIcms) {
        this.aliqIcms = aliqIcms;
    }
    public BigDecimal getVrDoIcms() {
        return vrDoIcms;
    }
    public void setVrDoIcms(BigDecimal vrDoIcms) {
        this.vrDoIcms = vrDoIcms;
    }
    public BigDecimal getStPisCofins() {
        return stPisCofins;
    }
    public void setStPisCofins(BigDecimal stPisCofins) {
        this.stPisCofins = stPisCofins;
    }
    public BigDecimal getBcPisCofins() {
        return bcPisCofins;
    }
    public void setBcPisCofins(BigDecimal bcPisCofins) {
        this.bcPisCofins = bcPisCofins;
    }
    public String getRegimeApuPisCofins() {
        return regimeApuPisCofins;
    }
    public void setRegimeApuPisCofins(String regimeApuPisCofins) {
        this.regimeApuPisCofins = regimeApuPisCofins;
    }
    public BigDecimal getVrPis() {
        return vrPis;
    }
    public void setVrPis(BigDecimal vrPis) {
        this.vrPis = vrPis;
    }
    public BigDecimal getVrCofins() {
        return vrCofins;
    }
    public void setVrCofins(BigDecimal vrCofins) {
        this.vrCofins = vrCofins;
    }
    public String getStIPI() {
        return stIPI;
    }
    public void setStIPI(String stIPI) {
        this.stIPI = stIPI;
    }
    public String getCodIPI() {
        return codIPI;
    }
    public void setCodIPI(String codIPI) {
        this.codIPI = codIPI;
    }
    public BigDecimal getAliqIPI() {
        return aliqIPI;
    }
    public void setAliqIPI(BigDecimal aliqIPI) {
        this.aliqIPI = aliqIPI;
    }
    public BigDecimal getVrIPI() {
        return vrIPI;
    }
    public void setVrIPI(BigDecimal vrIPI) {
        this.vrIPI = vrIPI;
    }
    public BigDecimal getVrTotalServ() {
        return vrTotalServ;
    }
    public void setVrTotalServ(BigDecimal vrTotalServ) {
        this.vrTotalServ = vrTotalServ;
    }
    public BigDecimal getBcISSQN() {
        return bcISSQN;
    }
    public void setBcISSQN(BigDecimal bcISSQN) {
        this.bcISSQN = bcISSQN;
    }
    public BigDecimal getVrISSQN() {
        return vrISSQN;
    }
    public void setVrISSQN(BigDecimal vrISSQN) {
        this.vrISSQN = vrISSQN;
    }
    public BigDecimal getRetIRRF() {
        return retIRRF;
    }
    public void setRetIRRF(BigDecimal retIRRF) {
        this.retIRRF = retIRRF;
    }
    public BigDecimal getRetPisCofins() {
        return retPisCofins;
    }
    public void setRetPisCofins(BigDecimal retPisCofins) {
        this.retPisCofins = retPisCofins;
    }
   

    
}
