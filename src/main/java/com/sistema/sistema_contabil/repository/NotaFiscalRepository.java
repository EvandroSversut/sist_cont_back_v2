package com.sistema.sistema_contabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.sistema_contabil.model.NotaFiscal;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {

    
    // 🧮 Soma do valor total das notas fiscais
    @Query("SELECT SUM(CAST(n.geraisNfe.vrTotalNfe AS double)) FROM NotaFiscal n")
    Double somarTotalVendas();

    // 📦 Quantidade total de notas emitidas
    @Query("SELECT COUNT(n) FROM NotaFiscal n")
    Long contarNotasEmitidas();
   
}
