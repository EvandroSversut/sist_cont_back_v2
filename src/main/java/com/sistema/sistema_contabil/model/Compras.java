package com.sistema.sistema_contabil.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "compras")
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compras_seq")
    @SequenceGenerator(name = "compras_seq", sequenceName = "compras_seq", allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pessoa_juridica_id", nullable = false)
    private PessoaJuridica pessoaJuridica;
  
    @Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCompra;
    
    @Column(nullable = false)
    private String numeroNota;

    @Column(nullable = false)
    private String serieNota;

    @Column(nullable = false)
    private String descricaoNota;
    
	@Column(nullable = false)
	private BigDecimal valorTotal;

    private BigDecimal valorDesconto;

	@Column(nullable = false)
	private BigDecimal valorIcms;

      // 💡 RELACIONAMENTO COM ITENS DE COMPRA
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItensCompra> itens = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }

    public String getSerieNota() {
        return serieNota;
    }

    public void setSerieNota(String serieNota) {
        this.serieNota = serieNota;
    }

    public String getDescricaoNota() {
        return descricaoNota;
    }

    public void setDescricaoNota(String descricaoNota) {
        this.descricaoNota = descricaoNota;
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

    public List<ItensCompra> getItens() {
        return itens;
    }

    public void setItens(List<ItensCompra> itens) {
        this.itens = itens;
    }
  
    
   
    
}
 