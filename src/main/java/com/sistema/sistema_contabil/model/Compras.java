package com.sistema.sistema_contabil.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.*;

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

  
    
   
}
 