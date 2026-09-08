package com.sistema.sistema_contabil.model.nfe.tributacao;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Embeddable existe apenas para organizar dados
// Essa classe esta ligada com a classe "TributacaoItem.java"
// Esses campos vão para a tabela principal
// Vira um Embedded na classe principal
// Crie Embeddable somente qdo ele existir dentro de outro
// Ex: endereco, telefone,tributacaoItem, TotaisNfe, pagamento, transporte
// Eles nao fazem sentido isolados.
@Entity
public class Cbs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String classificacao;

    private BigDecimal baseCalculo;

    private BigDecimal aliquota;

    private BigDecimal valor;

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
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