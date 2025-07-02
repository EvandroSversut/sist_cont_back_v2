package com.sistema.sistema_contabil.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Pagamento {

    private String formaPagamento;
    private double valorPago;
    private double valorTroco;
    
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

    // Getters e Setters...
    
}
