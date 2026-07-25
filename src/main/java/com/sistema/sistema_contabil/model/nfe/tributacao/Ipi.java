package com.sistema.sistema_contabil.model.nfe.Tributacao;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

    @Entity
    public class Ipi {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String cst;

        private String codigoEnquadramento;

        private BigDecimal baseCalculo;

        private BigDecimal aliquota;

        private BigDecimal valor;

        public String getCst() {
            return cst;
        }

        public void setCst(String cst) {
            this.cst = cst;
        }

        public String getCodigoEnquadramento() {
            return codigoEnquadramento;
        }

        public void setCodigoEnquadramento(String codigoEnquadramento) {
            this.codigoEnquadramento = codigoEnquadramento;
        }

        public BigDecimal getBaseCalculo() {
            return baseCalculo;
        }

        public void setBaseCalculo(BigDecimal baseCalculo) {
            this.baseCalculo = baseCalculo;
        }

        public BigDecimal getAliquota() {
            return aliquota;
        }

        public void setAliquota(BigDecimal aliquota) {
            this.aliquota = aliquota;
        }

        public BigDecimal getValor() {
            return valor;
        }

        public void setValor(BigDecimal valor) {
            this.valor = valor;
        }

        
}