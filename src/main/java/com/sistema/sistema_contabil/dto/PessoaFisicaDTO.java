package com.sistema.sistema_contabil.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF; // Ótima para validar CPF!

@Data
public class PessoaFisicaDTO {
    @NotBlank(message = "O nome não pode ser vazio.")
    @Size(min = 3, max = 100)
    public String nome;

    @NotBlank(message = "O CPF não pode ser vazio.")
    @CPF(message = "CPF inválido.") // Validação específica para CPF
    public String cpf;

    public String telefone;
    public String rua;
    public String numero;
    public String complemento;
    public String bairro;
    public String cep;
    public String cidade;
    public String uf;
    public String rg;

}
