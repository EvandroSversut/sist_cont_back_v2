package com.sistema.sistema_contabil.model.produto;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class TributacaoProduto {

    @Id
    private Long id;

    @OneToOne
    private Produto produto;



}