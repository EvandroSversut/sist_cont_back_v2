package com.sistema.sistema_contabil.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Municipios {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ibge_seq")
    @SequenceGenerator(name = "ibge_seq", sequenceName = "ibge_seq", allocationSize = 1)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nomeMun;

    @Column(length = 2, nullable = false)
    private String ufIbge;

    @Column(length = 50, nullable = false)
    private String nomeUf;

    @Column(length = 7, nullable = false)
    private String codIbgeCompl;

    @Column(length = 30, nullable = false)
    private String regiao;


}
