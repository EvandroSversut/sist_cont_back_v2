package com.sistema.sistema_contabil.model;


import jakarta.persistence.Embeddable;

@Embeddable
public class Transporte {

    private String modFrete;
    private String transportadora;
    private String cnpjTransportadora;
    private String placaVeiculo;
    private String ufPlaca;
    private double valorFrete;
    
    public String getModFrete() {
        return modFrete;
    }
    public void setModFrete(String modFrete) {
        this.modFrete = modFrete;
    }
    public String getTransportadora() {
        return transportadora;
    }
    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }
    public String getCnpjTransportadora() {
        return cnpjTransportadora;
    }
    public void setCnpjTransportadora(String cnpjTransportadora) {
        this.cnpjTransportadora = cnpjTransportadora;
    }
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }
    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
    public String getUfPlaca() {
        return ufPlaca;
    }
    public void setUfPlaca(String ufPlaca) {
        this.ufPlaca = ufPlaca;
    }
    public double getValorFrete() {
        return valorFrete;
    }
    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    // Getters e Setters...

    
    
}
