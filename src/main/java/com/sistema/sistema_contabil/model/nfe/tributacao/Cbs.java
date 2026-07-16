package com.sistema.sistema_contabil.model.nfe.tributacao;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;

// @Embeddable existe apenas para organizar dados
// Essa classe esta ligada com a classe "TributacaoItem.java"
// Esses campos vão para a tabela principal
// Vira um Embedded na classe principal
// Crie Embeddable somente qdo ele existir dentro de outro
// Ex: endereco, telefone,tributacaoItem, TotaisNfe, pagamento, transporte
// Eles nao fazem sentido isolados.
@Embeddable
public class Cbs {

    private String classificacao;

    private BigDecimal baseCalculo;

    private BigDecimal aliquota;

    private BigDecimal valor;

}