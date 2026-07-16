package com.sistema.sistema_contabil.model.nfe.tributacao;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;

    @Embeddable
    public class Ipi {

        private String cst;

        private String codigoEnquadramento;

        private BigDecimal baseCalculo;

        private BigDecimal aliquota;

        private BigDecimal valor;

}