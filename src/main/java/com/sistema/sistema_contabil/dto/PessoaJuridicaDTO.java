package com.sistema.sistema_contabil.dto;

import com.sistema.sistema_contabil.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaJuridicaDTO {

    private Long id;

    @NotBlank(message = "Razão social é obrigatória")
    @Size(max = 150, message = "Razão social deve ter no máximo 150 caracteres")
    private String razaoSocial;

    @Size(max = 100, message = "Nome fantasia deve ter no máximo 100 caracteres")
    private String nomeFantasia;

    @NotBlank(message = "CNPJ é obrigatório")
    @CNPJ
    private String cnpj;

    @InscricaoEstadual
    private String inscEstadual;

    @InscricaoMunicipal(permitirIsento = true)
    private String inscMunicipal;

    @CNAE
    private String cnae;

    @Telefone(permitirFixo = true, permitirCelular = true)
    private String telefone;

    @Email(message = "Email deve ser válido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    // Campos de endereço
    @NotBlank(message = "Rua é obrigatória")
    @Size(max = 200, message = "Rua deve ter no máximo 200 caracteres")
    private String rua;

    @NotBlank(message = "Número é obrigatório")
    @Size(max = 10, message = "Número deve ter no máximo 10 caracteres")
    private String numero;

    @Size(max = 100, message = "Complemento deve ter no máximo 100 caracteres")
    private String complemento;

    @NotBlank(message = "Bairro é obrigatório")
    @Size(max = 100, message = "Bairro deve ter no máximo 100 caracteres")
    private String bairro;

    @NotBlank(message = "CEP é obrigatório")
    @CEP
    private String cep;

    @NotBlank(message = "Cidade é obrigatória")
    @Size(max = 100, message = "Cidade deve ter no máximo 100 caracteres")
    private String cidade;

    @NotBlank(message = "UF é obrigatório")
    @Size(min = 2, max = 2, message = "UF deve ter exatamente 2 caracteres")
    @Pattern(regexp = "[A-Z]{2}", message = "UF deve conter apenas letras maiúsculas")
    private String uf;


    /**
     * Método para exibição formatada dos dados da pessoa jurídica
     * Útil para logs e debugging
     *
     * @return String formatada com os dados da empresa
     */
    public String imprimirBonito() {
        return String.format("""
                        
                        ************* PESSOA JURÍDICA *************
                        ID: %s
                        CNPJ: %s
                        Razão Social: %s
                        Nome Fantasia: %s
                        CNAE: %s
                        Telefone: %s
                        Email: %s
                        Endereço: %s, %s - %s%s
                        Cidade: %s - %s | CEP: %s
                        Inscrição Estadual: %s
                        Inscrição Municipal: %s
                        *******************************************
                        """,
                id != null ? id : "N/A",
                cnpj != null ? cnpj : "N/A",
                razaoSocial != null ? razaoSocial : "N/A",
                nomeFantasia != null ? nomeFantasia : "N/A",
                cnae != null ? cnae : "N/A",
                telefone != null ? telefone : "N/A",
                email != null ? email : "N/A",
                rua != null ? rua : "N/A",
                numero != null ? numero : "N/A",
                bairro != null ? bairro : "N/A",
                (complemento != null && !complemento.trim().isEmpty()) ?
                        " (" + complemento + ")" : "",
                cidade != null ? cidade : "N/A",
                uf != null ? uf : "N/A",
                cep != null ? cep : "N/A",
                inscEstadual != null ? inscEstadual : "N/A",
                inscMunicipal != null ? inscMunicipal : "N/A"
        );
    }

    /**
     * Método para exibição resumida (sem dados sensíveis)
     * Útil para logs públicos
     *
     * @return String com resumo da empresa
     */
    public String imprimirResumo() {
        return String.format("PessoaJuridica{id=%s, razaoSocial='%s', cnpj='%s'}",
                id, razaoSocial,
                cnpj != null ? cnpj.replaceAll("(\\d{2})\\.(\\d{3})\\.(\\d{3})/(\\d{4})-(\\d{2})",
                        "$1.***.***/$4-**") : "N/A");
    }

    /**
     * Método para verificar se a empresa tem endereço completo
     *
     * @return true se todos os campos obrigatórios de endereço estão preenchidos
     */
    @JsonIgnore
    public boolean isEnderecoCompleto() {
        return rua != null && !rua.trim().isEmpty() &&
                numero != null && !numero.trim().isEmpty() &&
                bairro != null && !bairro.trim().isEmpty() &&
                cidade != null && !cidade.trim().isEmpty() &&
                uf != null && !uf.trim().isEmpty() &&
                cep != null && !cep.trim().isEmpty();
    }

    /**
     * Método para verificar se é uma empresa ativa (com dados mínimos)
     *
     * @return true se tem os dados essenciais preenchidos
     */
    @JsonIgnore
    public boolean isEmpresaAtiva() {
        return razaoSocial != null && !razaoSocial.trim().isEmpty() &&
                cnpj != null && !cnpj.trim().isEmpty() &&
                email != null && !email.trim().isEmpty();
    }


}
       
        
    

