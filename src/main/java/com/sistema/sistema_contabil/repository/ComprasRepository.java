package com.sistema.sistema_contabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.sistema_contabil.model.compras.Compras;

@Repository
public interface ComprasRepository extends JpaRepository<Compras, Long> {
}
