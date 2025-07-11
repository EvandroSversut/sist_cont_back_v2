package com.sistema.sistema_contabil.dto;

import lombok.Data;

      // este @Data serve para deixar o print mais bonito no 
      // service -> lista.forEach(pj -> logger.info(pj.toString()));
      // para para isso tem que comentar o toString pq ele sobrescreve o lombok
@Data
public class PessoaJuridicaDTO {
    
    private Long id;
    public String razaoSocial;
    public String nomeFantasia;
    public String cnpj;
    public String inscEstadual;
    public String inscMunicipal;
    public String cnae;
    public String telefone;
    public String email;
    public String rua;
    public String numero;
    public String complemento;
    public String bairro;
    public String cep;
    public String cidade;
    public String uf;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getInscEstadual() {
        return inscEstadual;
    }
    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }
    public String getInscMunicipal() {
        return inscMunicipal;
    }
    public void setInscMunicipal(String inscMunicipal) {
        this.inscMunicipal = inscMunicipal;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
/* 
    @Override
    public String toString() {
        return "PessoaJuridicaDTO [id=" + id + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia
                + ", cnpj=" + cnpj + ", inscEstadual=" + inscEstadual + ", inscMunicipal=" + inscMunicipal
                + ", telefone=" + telefone + ", email=" + email + ", rua=" + rua + ", numero=" + numero
                + ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade
                + ", uf=" + uf + "]";
    }
*/
    
     // 🔥 Método para imprimir organizado
    public String imprimirBonito() {
        return "\n************* PESSOA JURÍDICA *************" +
                "\nID: " + id +
                "\nCNPJ: " + cnpj +
                "\nRazão Social: " + razaoSocial +
                "\nNome Fantasia: " + nomeFantasia +
                 "\nCNAE: " + cnae +
                "\nTelefone: " + telefone +
                "\nEmail: " + email +
                "\nEndereço: " + rua + ", " + numero + " - " + bairro +
                (complemento != null && !complemento.isEmpty() ? " (" + complemento + ")" : "") +
                "\nCidade: " + cidade + " - " + uf + " | CEP: " + cep +
                "\nInscrição Estadual: " + inscEstadual +
                "\nInscrição Municipal: " + inscMunicipal +
                "\n*******************************************\n";
    }
}
       
        
    

