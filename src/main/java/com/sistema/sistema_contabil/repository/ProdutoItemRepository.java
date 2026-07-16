package com.sistema.sistema_contabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.sistema_contabil.model.nfe.ItemNotaFiscal;

public interface ProdutoItemRepository extends JpaRepository<ItemNotaFiscal, Long> {
}

