package com.sistema.sistema_contabil.model.produto;

import com.sistema.sistema_contabil.model.nfe.tributacao.Cbs;
import com.sistema.sistema_contabil.model.nfe.tributacao.Cofins;
import com.sistema.sistema_contabil.model.nfe.tributacao.Ibs;
import com.sistema.sistema_contabil.model.nfe.tributacao.Icms;
import com.sistema.sistema_contabil.model.nfe.tributacao.ImpostoSeletivo;
import com.sistema.sistema_contabil.model.nfe.tributacao.Ipi;
import com.sistema.sistema_contabil.model.nfe.tributacao.Pis;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class TributacaoProduto {

    @Id
    private Long id;

    @OneToOne
    private Produtos produto;

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

    @Embedded
    private Cbs cbs;

    @Embedded
    private ImpostoSeletivo impostoSeletivo;

}