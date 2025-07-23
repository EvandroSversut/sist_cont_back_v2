package com.sistema.sistema_contabil.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.sistema_contabil.annotation.CEP;
import com.sistema.sistema_contabil.annotation.Telefone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaUsuarioDTO {

    private Long idPessoaFisica;
    private Long idUsuario;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    private String nome;

    @Email(message = "Email deve ser válido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @Telefone
    private String telefone;

    // Campos de endereço
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;

    @CEP
    private String cep;

    private String cidade;

    @Size(max = 2, message = "UF deve ter 2 caracteres")
    private String uf;

    // Documentos
    @NotBlank(message = "CPF é obrigatório")
    @CPF
    private String cpf;

    private String rg;

    // Campos de usuário
    @JsonIgnore // Não retornar senha em responses
    @Size(min = 8, message = "Senha deve ter pelo menos 8 caracteres")
    private String senha;

    // 🔥 Método para imprimir organizado
    public String imprimirBonito() {
        return "\n************* PESSOA FISICA E USUARIO *************" +
                "\nID PessFisica: " + idPessoaFisica +
                "\nID Usuario: " + idUsuario +
                "\nNome: " + nome +
                "\nRG: " + rg +
                "\nCPF: " + cpf +
                "\nTelefone: " + telefone +
                "\nEmail: " + email +
                "\nEndereço: " + rua + ", " + numero + " - " + bairro +
                (complemento != null && !complemento.isEmpty() ? " (" + complemento + ")" : "") +
                "\nCidade: " + cidade + " - " + uf + " | CEP: " + cep +
                "\n*******************************************\n";
    }


}
