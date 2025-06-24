package com.sistema.sistema_contabil.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

// esta classe faz vinculo com os produtos da nota
@Entity
@Table(name = "ItensCompra")
public class ItensCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itens_compra_seq")
    @SequenceGenerator(name = "itens_compra_seq", sequenceName = "itens_compra_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private Compras compra;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produtos produto;

    @Column(nullable = false)
    private BigDecimal quantidade;

    @Column(nullable = false)
    private BigDecimal valorUnitario;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compras getCompra() {
        return compra;
    }

    public void setCompra(Compras compra) {
        this.compra = compra;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

  
    
   
}
 