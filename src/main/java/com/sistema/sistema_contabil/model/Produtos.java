package com.sistema.sistema_contabil.model;

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
    private String descricao;
    
	 
    
   
}
 