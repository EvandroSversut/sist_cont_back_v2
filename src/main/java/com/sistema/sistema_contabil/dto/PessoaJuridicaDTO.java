package com.sistema.sistema_contabil.dto;

import lombok.Data;

      // este @Data serve para deixar o print mais bonito no 
      // service -> lista.forEach(pj -> logger.info(pj.toString()));
      // para para isso tem que comentar o toString pq ele sobrescreve o lombok
@Data
public class PessoaJuridicaDTO {
    
    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String inscEstadual;
    private String inscMunicipal;
    private String cnae;
    private String telefone;
    private String email;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String ibge;
    
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

    public String getCnae() {
        return cnae;
    }
    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

     public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge){
        this.ibge = ibge;
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
                "\nIbge: " + ibge +
                "\nEndereço: " + rua + ", " + numero + " - " + bairro +
                (complemento != null && !complemento.isEmpty() ? " (" + complemento + ")" : "") +
                "\nCidade: " + cidade + " - " + uf + " | CEP: " + cep +
                "\nInscrição Estadual: " + inscEstadual +
                "\nInscrição Municipal: " + inscMunicipal +
                "\n*******************************************\n";
    }
}
       
        
    

