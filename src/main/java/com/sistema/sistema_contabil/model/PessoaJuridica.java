package com.sistema.sistema_contabil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa {

    private String tipo; // EMITENTE, DESTINATARIO, TRANSPORTADORA
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String ie;
    private String inscMun;
    private String cnae;
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
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
    public String getIe() {
        return ie;
    }
    public void setIe(String ie) {
        this.ie = ie;
    }
    public String getInscMun() {
        return inscMun;
    }
    public void setInscMun(String inscMun) {
        this.inscMun = inscMun;
    }
    public String getCnae() {
        return cnae;
    }
    public void setCnae(String cnae) {
        this.cnae = cnae;
    }
    
    @Override
    public String toString() {
        return "PessoaJuridica [tipo=" + tipo + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", nomeFantasia="
                + nomeFantasia + ", ie=" + ie + ", inscMun=" + inscMun + ", cnae=" + cnae + ", getTipo()=" + getTipo()
                + ", getCnpj()=" + getCnpj() + ", getRazaoSocial()=" + getRazaoSocial() + ", getNomeFantasia()="
                + getNomeFantasia() + ", getId()=" + getId() + ", getIe()=" + getIe() + ", getTelefone()="
                + getTelefone() + ", getInscMun()=" + getInscMun() + ", getRua()=" + getRua() + ", getCnae()="
                + getCnae() + ", getClass()=" + getClass() + ", getNumero()=" + getNumero() + ", getComplemento()="
                + getComplemento() + ", getBairro()=" + getBairro() + ", getCep()=" + getCep() + ", getCidade()="
                + getCidade() + ", getUf()=" + getUf() + ", getEmail()=" + getEmail() + ", toString()="
                + super.toString() + ", hashCode()=" + hashCode() + "]";
    }

    
}
