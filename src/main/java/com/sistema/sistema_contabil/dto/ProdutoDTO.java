package com.sistema.sistema_contabil.dto;

import lombok.Data;

@Data
public class ProdutoDTO {
    
    private String codigo;
    private String descricao;
    private String ncm;
    private String cfop;
    private String unidade;
    private double quantidade;
    private double valorUnitario;
    private double desconto;
    private double vrTotalProd;
    private double frete;
    private double seguro;
    private double outraDesp;
    private double icms;
    private double ipi;
    private double pis;
    private double cofins;
    private double iss;
        
}
