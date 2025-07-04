package com.sistema.sistema_contabil.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nota_seq")
    @SequenceGenerator(name = "nota_seq", sequenceName = "nota_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Pessoa emitente;

    // 🔗 Relacionamento com destinatário
    @ManyToOne
    private Pessoa destinatario;

        // 🚚 Dados de transporte
    @Embedded
    private Transporte transportadora;

    // 💵 Dados de pagamento
    @Embedded
    private Pagamento pagamento;

    // 🔗 Itens da nota
    @OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemNotaFiscal> itens;

    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Lob
    private String xml; // será preenchido após gerar

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getEmitente() {
        return emitente;
    }

    public void setEmitente(Pessoa emitente) {
        this.emitente = emitente;
    }

    public Pessoa getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Pessoa destinatario) {
        this.destinatario = destinatario;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public List<ItemNotaFiscal> getItens() {
        return itens;
    }

    public void setItens(List<ItemNotaFiscal> itens) {
        this.itens = itens;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public Transporte getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transporte transportadora) {
        this.transportadora = transportadora;
    }

   
    
}