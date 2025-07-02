package com.sistema.sistema_contabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.sistema_contabil.model.ProdutoItem;

public interface ProdutoItemRepository extends JpaRepository<ProdutoItem, Long> {
}

