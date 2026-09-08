package com.sistema.sistema_contabil.model.nfe.tributacao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class TributacaoItem {
    
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Icms icms;

    @OneToOne(cascade = CascadeType.ALL)
    private Pis pis;

    @OneToOne(cascade = CascadeType.ALL)
    private Cofins cofins;

   @OneToOne(cascade = CascadeType.ALL)
    private Ipi ipi;

    @OneToOne(cascade = CascadeType.ALL)
    private Ibs ibs;

    // os detalhes estao na classe "Cbs.java"
    // Embedded é o uso do objeto
    // Embeddable define o bloco; Embedded usa o bloco
    @OneToOne(cascade = CascadeType.ALL)
    private Cbs cbs;

    @OneToOne(cascade = CascadeType.ALL)
    private ImpostoSeletivo impostoSeletivo;


}
