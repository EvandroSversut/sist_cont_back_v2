package com.sistema.sistema_contabil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa {

    private String tipo; // EMITENTE, DESTINATARIO, TRANSPORTADORA
    private String cnpj;
    private String razaoSocial;
    private String ie;
    
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
    public String getIe() {
        return ie;
    }
    public void setIe(String ie) {
        this.ie = ie;
    }
    @Override
    public String toString() {
        return "PessoaJuridica [tipo=" + tipo + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", ie=" + ie
                + ", getTipo()=" + getTipo() + ", getCnpj()=" + getCnpj() + ", getRazaoSocial()=" + getRazaoSocial()
                + ", getIe()=" + getIe() + ", getId()=" + getId() + ", getTelefone()=" + getTelefone() + ", getRua()="
                + getRua() + ", getClass()=" + getClass() + ", getNumero()=" + getNumero() + ", getComplemento()="
                + getComplemento() + ", getBairro()=" + getBairro() + ", getCep()=" + getCep() + ", getCidade()="
                + getCidade() + ", getUf()=" + getUf() + ", getEmail()=" + getEmail() + ", toString()="
                + super.toString() + ", hashCode()=" + hashCode() + "]";
    }
   
    
   
        
       
}
