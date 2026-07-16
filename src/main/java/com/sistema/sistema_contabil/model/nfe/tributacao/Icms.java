package com.sistema.sistema_contabil.model.nfe.tributacao;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;

@Embeddable
public class Icms {

    private String origem;

    private String cst;

    private String csosn;

    private String cfop;

    private BigDecimal baseCalculo;

    private BigDecimal aliquota;

    private BigDecimal valor;

}
