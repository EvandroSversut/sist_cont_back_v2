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
    public double aliquotaIcms;

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
    public double getAliquotaIcms() {
        return aliquotaIcms;
    }
    public void setAliquotaIcms(double aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    
    
}
