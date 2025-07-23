package com.sistema.sistema_contabil.dto;

import lombok.Data;

@Data
public class PagamentoDTO {

    public String formaPagamento;
    public double valorPago;
    public double valorTroco;

}
