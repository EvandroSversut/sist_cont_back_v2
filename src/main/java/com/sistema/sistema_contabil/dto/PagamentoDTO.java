package com.sistema.sistema_contabil.dto;

public class PagamentoDTO {

    public String formaPagamento;
    public double valorPago;
    public double valorTroco;
    
    public String getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    public double getValorPago() {
        return valorPago;
    }
    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
    public double getValorTroco() {
        return valorTroco;
    }
    public void setValorTroco(double valorTroco) {
        this.valorTroco = valorTroco;
    }

    
}
