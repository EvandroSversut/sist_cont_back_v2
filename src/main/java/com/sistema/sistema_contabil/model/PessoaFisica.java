package com.sistema.sistema_contabil.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String rg;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "PessoaFisica [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", getNome()=" + getNome() + ", getCpf()="
                + getCpf() + ", getRg()=" + getRg() + ", getId()=" + getId() + ", getTelefone()=" + getTelefone()
                + ", getRua()=" + getRua() + ", getClass()=" + getClass() + ", getNumero()=" + getNumero()
                + ", getComplemento()=" + getComplemento() + ", getBairro()=" + getBairro() + ", getCep()=" + getCep()
                + ", getCidade()=" + getCidade() + ", getUf()=" + getUf() + ", getEmail()=" + getEmail()
                + ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + "]";
    }

    
   
    
}
