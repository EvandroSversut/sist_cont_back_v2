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
    private String ncm;
    private String cfop;
    private String unidade;
    private double quantidade;
    private double valorUnitario;
    private double vrTotalProd;
    private double desconto;
    private double frete;
    private double seguro;
    private double outraDesp;
    private double icms;
    private double ipi;
    private double pis;
    private double cofins;
    private double iss;
   
    // 🔗 Referência à nota fiscal
    @ManyToOne
    private NotaFiscal notaFiscal;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
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

        public double getVrTotalProd() {
        return vrTotalProd;
    }

    public void setVrTotalProd(double vrTotalProd) {
        this.vrTotalProd = vrTotalProd;
    }


     public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double getSeguro() {
        return seguro;
    }

    public void setSeguro(double seguro) {
        this.seguro = seguro;
    }

    public double getOutraDesp() {
        return outraDesp;
    }

    public void setOutraDesp(double outraDesp) {
        this.outraDesp = outraDesp;
    }

    public double getIcms() {
        return icms;
    }

    public void setIcms(double icms) {
        this.icms = icms;
    }

    public double getIpi() {
        return ipi;
    }

    public void setIpi(double ipi) {
        this.ipi = ipi;
    }

    public double getPis() {
        return pis;
    }

    public void setPis(double pis) {
        this.pis = pis;
    }

    public double getCofins() {
        return cofins;
    }

    public void setCofins(double cofins) {
        this.cofins = cofins;
    }

    public double getIss() {
        return iss;
    }

    public void setIss(double iss) {
        this.iss = iss;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    @Override
    public String toString() {
        return "ItemNotaFiscal [id=" + id + ", descricao=" + descricao + ", ncm=" + ncm + ", cfop=" + cfop
                + ", unidade=" + unidade + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario
                + ", vrTotalProd=" + vrTotalProd + ", desconto=" + desconto + ", frete=" + frete + ", seguro=" + seguro
                + ", outraDesp=" + outraDesp + ", icms=" + icms + ", ipi=" + ipi + ", pis=" + pis + ", cofins=" + cofins
                + ", iss=" + iss + ", notaFiscal=" + notaFiscal + ", getId()=" + getId() + ", getDescricao()="
                + getDescricao() + ", getNcm()=" + getNcm() + ", getCfop()=" + getCfop() + ", getUnidade()="
                + getUnidade() + ", getClass()=" + getClass() + ", getQuantidade()=" + getQuantidade()
                + ", getValorUnitario()=" + getValorUnitario() + ", getVrTotalProd()=" + getVrTotalProd()
                + ", getDesconto()=" + getDesconto() + ", getFrete()=" + getFrete() + ", getSeguro()=" + getSeguro()
                + ", getOutraDesp()=" + getOutraDesp() + ", getIcms()=" + getIcms() + ", getIpi()=" + getIpi()
                + ", getPis()=" + getPis() + ", getCofins()=" + getCofins() + ", hashCode()=" + hashCode()
                + ", getIss()=" + getIss() + ", getNotaFiscal()=" + getNotaFiscal() + ", toString()=" + super.toString()
                + "]";
    }


   
    
}
