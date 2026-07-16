package com.sistema.sistema_contabil.model.nfe.tributacao;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;

@Embeddable
public class Ibs {

    private String classificacao;

    private BigDecimal baseCalculo;

    private BigDecimal aliquota;

    private BigDecimal valor;

}