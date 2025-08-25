package com.sistema.sistema_contabil.model;

import jakarta.persistence.*;

@Entity
public class ItemNotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_item_seq")
    @SequenceGenerator(name = "produto_item_seq", sequenceName = "produto_item_seq", allocationSize = 1)
    private Long id;

    private String codigo;
    private String descricao;
    private String codBarras;
    private String ncm;
    private String produtoST;
    private String cst;
    private String csosn;
    private String cfop;
    private String unidade;
    private double quantidade;
    private double valorUnitario;
    private double desconto;
    private double vrTotalProd;
    private String origem;
    private double bcIcmsProd;
    private double aliqIcms;
    private double vrDoIcms;
    private double stPisCofins;
    private double bcPisCofins;
    private String regimeApuPisCofins;
    private double vrPis;
    private double vrCofins;
    private String stIPI;
    private String codIPI;
    private double aliqIPI;
    private double vrIPI;
    private double vrTotalServ;
    private double bcISSQN;
    private double vrISSQN;
    private double retIRRF;
    private double retPisCofins;
   
    // 🔗 Referência à nota fiscal
    @ManyToOne
    private NotaFiscal notaFiscal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getVrTotalProd() {
        return vrTotalProd;
    }

    public void setVrTotalProd(double vrTotalProd) {
        this.vrTotalProd = vrTotalProd;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public double getBcIcmsProd() {
        return bcIcmsProd;
    }

    public void setBcIcmsProd(double bcIcmsProd) {
        this.bcIcmsProd = bcIcmsProd;
    }

    public double getAliqIcms() {
        return aliqIcms;
    }

    public void setAliqIcms(double aliqIcms) {
        this.aliqIcms = aliqIcms;
    }

    public double getVrDoIcms() {
        return vrDoIcms;
    }

    public void setVrDoIcms(double vrDoIcms) {
        this.vrDoIcms = vrDoIcms;
    }

    public double getStPisCofins() {
        return stPisCofins;
    }

    public void setStPisCofins(double stPisCofins) {
        this.stPisCofins = stPisCofins;
    }

    public double getBcPisCofins() {
        return bcPisCofins;
    }

    public void setBcPisCofins(double bcPisCofins) {
        this.bcPisCofins = bcPisCofins;
    }

    public String getRegimeApuPisCofins() {
        return regimeApuPisCofins;
    }

    public void setRegimeApuPisCofins(String regimeApuPisCofins) {
        this.regimeApuPisCofins = regimeApuPisCofins;
    }

    public double getVrPis() {
        return vrPis;
    }

    public void setVrPis(double vrPis) {
        this.vrPis = vrPis;
    }

    public double getVrCofins() {
        return vrCofins;
    }

    public void setVrCofins(double vrCofins) {
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

    public double getAliqIPI() {
        return aliqIPI;
    }

    public void setAliqIPI(double aliqIPI) {
        this.aliqIPI = aliqIPI;
    }

    public double getVrIPI() {
        return vrIPI;
    }

    public void setVrIPI(double vrIPI) {
        this.vrIPI = vrIPI;
    }

    public double getVrTotalServ() {
        return vrTotalServ;
    }

    public void setVrTotalServ(double vrTotalServ) {
        this.vrTotalServ = vrTotalServ;
    }

    public double getBcISSQN() {
        return bcISSQN;
    }

    public void setBcISSQN(double bcISSQN) {
        this.bcISSQN = bcISSQN;
    }

    public double getVrISSQN() {
        return vrISSQN;
    }

    public void setVrISSQN(double vrISSQN) {
        this.vrISSQN = vrISSQN;
    }

    public double getRetIRRF() {
        return retIRRF;
    }

    public void setRetIRRF(double retIRRF) {
        this.retIRRF = retIRRF;
    }

    public double getRetPisCofins() {
        return retPisCofins;
    }

    public void setRetPisCofins(double retPisCofins) {
        this.retPisCofins = retPisCofins;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    @Override
    public String toString() {
        return "ItemNotaFiscal [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", codBarras="
                + codBarras + ", ncm=" + ncm + ", produtoST=" + produtoST + ", cst=" + cst + ", csosn=" + csosn
                + ", cfop=" + cfop + ", unidade=" + unidade + ", quantidade=" + quantidade + ", valorUnitario="
                + valorUnitario + ", desconto=" + desconto + ", vrTotalProd=" + vrTotalProd + ", origem=" + origem
                + ", bcIcmsProd=" + bcIcmsProd + ", aliqIcms=" + aliqIcms + ", vrDoIcms=" + vrDoIcms + ", stPisCofins="
                + stPisCofins + ", bcPisCofins=" + bcPisCofins + ", regimeApuPisCofins=" + regimeApuPisCofins
                + ", vrPis=" + vrPis + ", vrCofins=" + vrCofins + ", stIPI=" + stIPI + ", codIPI=" + codIPI
                + ", aliqIPI=" + aliqIPI + ", vrIPI=" + vrIPI + ", vrTotalServ=" + vrTotalServ + ", bcISSQN=" + bcISSQN
                + ", vrISSQN=" + vrISSQN + ", retIRRF=" + retIRRF + ", retPisCofins=" + retPisCofins + ", notaFiscal="
                + notaFiscal + "]";
    }

    
    
}
