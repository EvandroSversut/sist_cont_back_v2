package com.sistema.sistema_contabil.dto;

public class PessoaUsuarioDTO {
    
    private Long idPessoaFisica;
    private Long idUsuario;
    public String nome;
    public String cpf;
    public String rg;
    public String telefone;
    public String rua;
    public String numero;
    public String complemento;
    public String bairro;
    public String cep;
    public String cidade;
    public String uf;
    public String email;
    public String senha;
    
    
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
    
    public Long getIdPessoaFisica() {
        return idPessoaFisica;
    }
    public void setIdPessoaFisica(Long idPessoaFisica) {
        this.idPessoaFisica = idPessoaFisica;
    }
    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
     
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
