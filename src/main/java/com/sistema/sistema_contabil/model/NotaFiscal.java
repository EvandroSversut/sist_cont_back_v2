package com.sistema.sistema_contabil.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

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
   
            
}