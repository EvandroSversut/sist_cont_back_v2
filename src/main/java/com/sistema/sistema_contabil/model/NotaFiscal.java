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

    @Embedded
    private GeraisNfe geraisNfe;

    // 🔗 Relacionamento com emitente. Muitas nfe para um emitente
    // Cada nota fiscal esta associada a um unica PessoaJuridica (Emitente ou Destinatario)
    // Essa associação é feita via chave estrangeira (foreign key) no banco, que aponta para o id da PessoaJuridica.
    @ManyToOne
    private PessoaJuridica emitente;

    // 🔗 Relacionamento com destinatário. Muitas nfe para um destinatario
    // Cada nota fiscal esta associada a um unica PessoaJuridica (Emitente ou Destinatario)
    // Essa associação é feita via chave estrangeira (foreign key) no banco, que aponta para o id da PessoaJuridica.
    @ManyToOne
    private PessoaJuridica destinatario;

    // 🚚 Dados de transporte
    @Embedded
    private Transporte transportadora;

    // 💵 Dados de pagamento
    @Embedded
    private Pagamento pagamento;

    // 🔗 Itens da nota
    @OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemNotaFiscal> itens;

    private BigDecimal baseCalculo;

    @Column(name = "valor_icms")
    private BigDecimal vrIcms;

    @Column(name = "valor_total_prod")
    private BigDecimal vrTotalProd;

    @Column(name = "valor_total_nfe")
    private BigDecimal vrTotalNfe;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GeraisNfe getGeraisNfe() {
        return geraisNfe;
    }

    public void setGeraisNfe(GeraisNfe geraisNfe) {
        this.geraisNfe = geraisNfe;
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

    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(BigDecimal baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    public BigDecimal getVrIcms() {
        return vrIcms;
    }

    public void setVrIcms(BigDecimal vrIcms) {
        this.vrIcms = vrIcms;
    }

    public BigDecimal getVrTotalProd() {
        return vrTotalProd;
    }

    public void setVrTotalProd(BigDecimal vrTotalProd) {
        this.vrTotalProd = vrTotalProd;
    }

    public BigDecimal getVrTotalNfe() {
        return vrTotalNfe;
    }

    public void setVrTotalNfe(BigDecimal vrTotalNfe) {
        this.vrTotalNfe = vrTotalNfe;
    }

     
        
}