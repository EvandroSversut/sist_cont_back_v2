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

    public PessoaJuridica getEmitente() {
        return emitente;
    }

    public void setEmitente(PessoaJuridica emitente) {
        this.emitente = emitente;
    }

    public PessoaJuridica getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(PessoaJuridica destinatario) {
        this.destinatario = destinatario;
    }

    public String getNumeroNf() {
        return numeroNf;
    }

    public void setNumeroNf(String numeroNf) {
        this.numeroNf = numeroNf;
    }

    public String getSerieNf() {
        return serieNf;
    }

    public void setSerieNf(String serieNf) {
        this.serieNf = serieNf;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public String getChaveNfe() {
        return chaveNfe;
    }

    public void setChaveNfe(String chaveNfe) {
        this.chaveNfe = chaveNfe;
    }

    public String getStatusNfe() {
        return statusNfe;
    }

    public void setStatusNfe(String statusNfe) {
        this.statusNfe = statusNfe;
    }

    public String getXmlGerado() {
        return xmlGerado;
    }

    public void setXmlGerado(String xmlGerado) {
        this.xmlGerado = xmlGerado;
    }

    public String getProtocoloAutorizacao() {
        return protocoloAutorizacao;
    }

    public void setProtocoloAutorizacao(String protocoloAutorizacao) {
        this.protocoloAutorizacao = protocoloAutorizacao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Transporte getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transporte transportadora) {
        this.transportadora = transportadora;
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
   
        
}