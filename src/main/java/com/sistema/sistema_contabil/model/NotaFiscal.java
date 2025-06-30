package com.sistema.sistema_contabil.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nota_seq")
    @SequenceGenerator(name = "nota_seq", sequenceName = "nota_seq", allocationSize = 1)
    private Long id;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String xml;

    private LocalDateTime dataCadastro;

    // construtores
    public NotaFiscal() {
        this.dataCadastro = LocalDateTime.now();
    }

    public NotaFiscal(String xml) {
        this.xml = xml;
        this.dataCadastro = LocalDateTime.now();
    }

    // getters e setters
    public Long getId() {
        return id;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
