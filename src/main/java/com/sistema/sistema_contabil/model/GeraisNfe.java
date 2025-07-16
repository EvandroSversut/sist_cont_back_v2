package com.sistema.sistema_contabil.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class GeraisNfe {
    private String layout;
    private String idChaveAcesso;
    private String ufEmitente;
    private String codNumericoNFe;
    private String natOperacao;
    private String crt;
    private String serie;
    private String numeroNFe;
    private String dtHrEmissao;
    private String dtHrSaida;
    private String tipo;
    private String destinoOpe;
    private String ibge;
    private String formatoDanfe;
    private String tipoEmissao;
    private String digitoChave;
    private String ambiente; 
    private String finalidade;
    private String consumidorFinal;
    private String vendaPresencial;
    private String processoVersaoEmissor;

    public String getLayout() {
        return layout;
    }
    public void setLayout(String layout) {
        this.layout = layout;
    }
    public String getIdChaveAcesso() {
        return idChaveAcesso;
    }
    public void setIdChaveAcesso(String idChaveAcesso) {
        this.idChaveAcesso = idChaveAcesso;
    }
    public String getUfEmitente() {
        return ufEmitente;
    }
    public void setUfEmitente(String ufEmitente) {
        this.ufEmitente = ufEmitente;
    }
    public String getCodNumericoNFe() {
        return codNumericoNFe;
    }
    public void setCodNumericoNFe(String codNumericoNFe) {
        this.codNumericoNFe = codNumericoNFe;
    }
    public String getNatOperacao() {
        return natOperacao;
    }
    public void setNatOperacao(String natOperacao) {
        this.natOperacao = natOperacao;
    }
    public String getCrt() {
        return crt;
    }
    public void setCrt(String crt) {
        this.crt = crt;
    }
    public String getSerie() {
        return serie;
    }
    public void setSerie(String serie) {
        this.serie = serie;
    }
    public String getNumeroNFe() {
        return numeroNFe;
    }
    public void setNumeroNFe(String numeroNFe) {
        this.numeroNFe = numeroNFe;
    }
    public String getDtHrEmissao() {
        return dtHrEmissao;
    }
    public void setDtHrEmissao(String dtHrEmissao) {
        this.dtHrEmissao = dtHrEmissao;
    }
    public String getDtHrSaida() {
        return dtHrSaida;
    }
    public void setDtHrSaida(String dtHrSaida) {
        this.dtHrSaida = dtHrSaida;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDestinoOpe() {
        return destinoOpe;
    }
    public void setDestinoOpe(String destinoOpe) {
        this.destinoOpe = destinoOpe;
    }
    public String getIbge() {
        return ibge;
    }
    public void setIbge(String ibge) {
        this.ibge = ibge;
    }
    public String getFormatoDanfe() {
        return formatoDanfe;
    }
    public void setFormatoDanfe(String formatoDanfe) {
        this.formatoDanfe = formatoDanfe;
    }
    public String getTipoEmissao() {
        return tipoEmissao;
    }
    public void setTipoEmissao(String tipoEmissao) {
        this.tipoEmissao = tipoEmissao;
    }
    public String getDigitoChave() {
        return digitoChave;
    }
    public void setDigitoChave(String digitoChave) {
        this.digitoChave = digitoChave;
    }
    public String getAmbiente() {
        return ambiente;
    }
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }
    public String getFinalidade() {
        return finalidade;
    }
    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }
    public String getConsumidorFinal() {
        return consumidorFinal;
    }
    public void setConsumidorFinal(String consumidorFinal) {
        this.consumidorFinal = consumidorFinal;
    }
    public String getVendaPresencial() {
        return vendaPresencial;
    }
    public void setVendaPresencial(String vendaPresencial) {
        this.vendaPresencial = vendaPresencial;
    }
    public String getProcessoVersaoEmissor() {
        return processoVersaoEmissor;
    }
    public void setProcessoVersaoEmissor(String processoVersaoEmissor) {
        this.processoVersaoEmissor = processoVersaoEmissor;
    }

    // Getters e Setters
    
}
