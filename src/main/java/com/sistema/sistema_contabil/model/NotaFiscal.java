package com.sistema.sistema_contabil.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nota_seq")
    @SequenceGenerator(name = "nota_seq", sequenceName = "nota_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    private PessoaJuridica emitente;

    // 🔗 Relacionamento com destinatário
    @ManyToOne
    private PessoaJuridica destinatario;

    @Column(name = "numero_nf", nullable = false)
    private String numeroNf;

    @Column(name = "serie_nf", nullable = false)
    private String serieNf;

    @Column(name = "tipo_operacao", nullable = false)
    private String tipoOperacao;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @Column(name = "valor_desconto")
    private BigDecimal valorDesconto;

    @Column(name = "valor_icms")
    private BigDecimal valorIcms;

    @Column(name = "valor_frete")
    private BigDecimal valorFrete;

    @Column(name = "chave_nfe")
    private String chaveNfe;

    @Column(name = "status_nfe", nullable = false)
    private String statusNfe;

    @Column(name = "xml_gerado", columnDefinition = "TEXT")
    private String xmlGerado;

    @Column(name = "protocolo_autorizacao")
    private String protocoloAutorizacao;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "data_emissao", nullable = false)
    private LocalDateTime dataEmissao;

    // 🚚 Dados de transporte
    @Embedded
    private Transporte transportadora;

    // 💵 Dados de pagamento
    @Embedded
    private Pagamento pagamento;

    // 🔗 Itens da nota
    @OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemNotaFiscal> itens;
   
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