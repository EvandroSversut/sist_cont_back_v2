package com.sistema.sistema_contabil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;

// se nao colocar este "@Inheritance(strategy = InheritanceType.JOINED)"
// , as classes que herdarem vao criar as colunas desta classe
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq", allocationSize = 1)
    private Long id;
      
    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = true)
    private String numero;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = true)
    private String bairro;

    @Column(nullable = true)
    private String cep;

    @Column(nullable = true)
    private String cidade;

    @Column(nullable = true)
    private String uf;

    @Column(nullable = false)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", telefone=" + telefone + ", rua=" + rua + ", numero=" + numero
                + ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade
                + ", uf=" + uf + ", email=" + email + "]";
    }

    
   
}
 