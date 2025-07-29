package com.sistema.sistema_contabil.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ibge {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ibge_seq")
    private Long id;

    private String codIbge;
    private String nomeIbge;
    private String ufIbge;


}
