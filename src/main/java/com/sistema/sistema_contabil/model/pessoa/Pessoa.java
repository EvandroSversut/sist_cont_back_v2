package com.sistema.sistema_contabil.model.pessoa;

import jakarta.persistence.*;

// se nao colocar este "@Inheritance(strategy = InheritanceType.JOINED)"
// , as classes que herdarem vao criar as colunas desta classe
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq", allocationSize = 1)
    private Long id;
      
    @Column(nullable = true)
    private String telefone1;

    @Column(nullable = true)
    private String telefone2;

    @Column(nullable = true)
    private String emailContato;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
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

 
    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", telefone=" + telefone1 + ", rua=" + rua + ", numero=" + numero
                + ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade
                + ", uf=" + uf + "]";
    }

    
   
}
 