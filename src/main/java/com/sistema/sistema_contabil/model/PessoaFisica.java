package com.sistema.sistema_contabil.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String rg;


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
