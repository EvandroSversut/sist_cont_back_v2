package com.sistema.sistema_contabil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa {

    private String razaoSocial;        
    private String nomeFantasia;
    private String cnpj;
    private String inscMunicipal;
    private String inscEstadual;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getInscMunicipal() {
        return inscMunicipal;
    }
    public void setInscMunicipal(String inscMunicipal) {
        this.inscMunicipal = inscMunicipal;
    }
    public String getInscEstadual() {
        return inscEstadual;
    }
    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }
    
       
}
