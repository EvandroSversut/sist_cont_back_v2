package com.sistema.sistema_contabil.model.nfe.tributacao;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;

@Embeddable
public class ImpostoSeletivo {

    private String classificacao;

    private BigDecimal baseCalculo;

    private BigDecimal aliquota;

    private BigDecimal valor;

}