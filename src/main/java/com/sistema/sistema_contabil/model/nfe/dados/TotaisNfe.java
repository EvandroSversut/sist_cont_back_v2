package com.sistema.sistema_contabil.model.nfe.dados;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;

@Embeddable
public class TotaisNfe {

    private BigDecimal valorProdutos;

    private BigDecimal valorDesconto;

    private BigDecimal valorIcms;

    private BigDecimal valorPis;

    private BigDecimal valorCofins;

    private BigDecimal valorIpi;

    private BigDecimal valorIbs;

    private BigDecimal valorCbs;

    private BigDecimal valorIs;

    private BigDecimal valorNota;

}