package com.sistema.sistema_contabil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.sistema_contabil.model.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {

    Optional<Produtos> findByNomeProduto(String nomeProduto); // ✔️ correto

    List<Produtos> findAll(); // ✔️ opcional, já vem do JpaRepository
}
