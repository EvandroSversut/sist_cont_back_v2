package com.sistema.sistema_contabil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa {

    private String tipo; // EMITENTE, DESTINATARIO, TRANSPORTADORA. por enquanto nao estou enviando o tipo
                         // so esta aqui para utilizar futuramente, se necessario.
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String ie;
    private String inscMun;
    private String cnae;
    private String ibge;
    
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

       public String getIbge() {
        return ibge;
    }
    public void setIbge(String ibge) {
        this.ibge = ibge;
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
                + getIbge() + ", getIbge()="
                + super.toString() + ", hashCode()=" + hashCode() + "]";
    }
 
    
}
