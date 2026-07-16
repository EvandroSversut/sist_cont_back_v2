package com.sistema.sistema_contabil.model.nfe.tributacao;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class TributacaoItem {
    
    @Embedded
    private Icms icms;

    @Embedded
    private Pis pis;

    @Embedded
    private Cofins cofins;

    @Embedded
    private Ipi ipi;

    @Embedded
    private Ibs ibs;

    // os detalhes estao na classe "Cbs.java"
    // Embedded é o uso do objeto
    // Embeddable define o bloco; Embedded usa o bloco
    @Embedded
    private Cbs cbs;

    @Embedded
    private ImpostoSeletivo impostoSeletivo;


}
