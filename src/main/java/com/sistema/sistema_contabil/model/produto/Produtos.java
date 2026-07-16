package com.sistema.sistema_contabil.model.produto;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produtos {


    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtos_seq")
    @SequenceGenerator(name = "produtos_seq", sequenceName = "produtos_seq", allocationSize = 1)
    private Long id;

    //@OneToOne
    //@JoinColumn(name = "pessoa_juridica_id", nullable = false)
    //private PessoaJuridica pessoaJuridica;
  
    @Column(nullable = false)
    private String nomeProduto;

    @Column(nullable = false)
    private String unidade;

    @Column(nullable = false)
    private String ncm;

    private String descricao;

    private String gtin;

    private String cest;

    private String origem;

    private String cfopPadrao;

    private String cstIcms;

    private String csosn;

    private String cstPis;

    private String cstCofins;

    private String cstIpi;

    private BigDecimal aliqIcms;

    private BigDecimal aliqPis;

    private BigDecimal aliqCofins;

    private BigDecimal aliqIpi;

    // REFORMA TRIBUTARIA
    private String classificacaoIbs;
    private String classificacaoCbs;
    private String classificacaoIs;

    private BigDecimal aliqIbs;
    private BigDecimal aliqCbs;
    private BigDecimal aliqIs;

      
    
   
}
 