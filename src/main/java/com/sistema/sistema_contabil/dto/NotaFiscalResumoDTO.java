package com.sistema.sistema_contabil.dto;

import java.time.LocalDateTime;

public class NotaFiscalResumoDTO {

    private Long id;
    private String numero;
    private String serie;
    private LocalDateTime dtHrEmissao;
    private String destinatarioNome;
    private String valorTotal;
    private String status;

    public NotaFiscalResumoDTO(Long id, String numero, String serie,
                               LocalDateTime dtHrEmissao,
                               String destinatarioNome,
                               String valorTotal,
                               String status) {
        this.id = id;
        this.numero = numero;
        this.serie = serie;
        this.dtHrEmissao = dtHrEmissao;
        this.destinatarioNome = destinatarioNome;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getSerie() { return serie; }
    public void setSerie(String serie) { this.serie = serie; }

    public LocalDateTime getDtHrEmissao() { return dtHrEmissao; }
    public void setDtHrEmissao(LocalDateTime dtHrEmissao) { this.dtHrEmissao = dtHrEmissao; }

    public String getDestinatarioNome() { return destinatarioNome; }
    public void setDestinatarioNome(String destinatarioNome) { this.destinatarioNome = destinatarioNome; }

    public String getValorTotal() { return valorTotal; }
    public void setValorTotal(String valorTotal) { this.valorTotal = valorTotal; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
