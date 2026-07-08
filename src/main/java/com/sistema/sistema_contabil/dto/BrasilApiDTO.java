package com.sistema.sistema_contabil.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrasilApiDTO {

    private String cnpj;

    // esse @JsonProperty serve para traduzir o que vem da API (mapear nomes diferentes)
    // na API vem "razao_social" mas no meu DTO esta "razaoSocial"
    // eu poderia mudar aqui no DTO e entao nem precisaria dessa anotacao
    // mas quebraria o padrao java, entao melhor fazer a anotacao
    @JsonProperty("razao_social")
    private String razaoSocial;

    private String nomeFantasia;

    private String municipio;
    private String uf;
    private String emailContato;

    @JsonProperty("cnae_fiscal")
    private String cnae;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    @JsonProperty("ddd_telefone_1")
    private String telefone1;

    @JsonProperty("ddd_telefone_2")
    private String telefone2;
    
    @JsonProperty("codigo_municipio_ibge")
    private String ibge;

    // getters

    public String getCnpj() { return cnpj; }
    public String getRazaoSocial() { return razaoSocial; }
    public String getNomeFantasia() { return nomeFantasia; }
    public String getMunicipio() { return municipio; }
    public String getUf() { return uf; }
    public String getEmailContato() { return emailContato; }
    public String getCnae() { return cnae; }
    public String getLogradouro() { return logradouro; }
    public String getNumero() { return numero; }
    public String getComplemento() { return complemento; }
    public String getBairro() { return bairro; }
    public String getCep() { return cep; }
    public String getTelefone1() { return telefone1; }
    public String getTelefone2() { return telefone2; }
    public String getIbge() { return ibge; }
    
    
}