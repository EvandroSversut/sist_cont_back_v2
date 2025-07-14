package com.sistema.sistema_contabil.dto;

public class ProdutoDTO {
    
    public String codigo;
    public String descricao;
    public String ncm;
    public String cfop;
    public String unidade;
    public double quantidade;
    public double valorUnitario;
    public double desconto;
    private double valorTotal;
    private double frete;
    private double seguro;
    private double outraDesp;
    private double icms;
    private double ipi;
    private double pis;
    private double cofins;
    private double iss;
    
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
    public double getDesconto() {
        return desconto;
    }
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
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

  
    
    
}
