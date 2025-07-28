package com.sistema.sistema_contabil.model;

import jakarta.persistence.*;
import lombok.Data;

// se nao colocar este "@Inheritance(strategy = InheritanceType.JOINED)"
// , as classes que herdarem vao criar as colunas desta classe
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq", allocationSize = 1)
    private Long id;


    @Column(nullable = true)
    private String telefone;

    @Column(nullable = true)
    private String rua;

    @Column(nullable = true)
    private String numero;

    @Column(nullable = true)
    private String complemento;

    @Column(nullable = true)
    private String bairro;

    @Column(nullable = true)
    private String cep;

    @Column(nullable = true)
    private String cidade;

    @Column(nullable = true)
    private String uf;

    @Column(nullable = true)
    private String email;



    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", telefone=" + telefone + ", rua=" + rua + ", numero=" + numero
                + ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade
                + ", uf=" + uf + ", email=" + email + "]";
    }


}
 