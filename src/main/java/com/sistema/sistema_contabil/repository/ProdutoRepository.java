package com.sistema.sistema_contabil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.sistema_contabil.model.produto.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByNomeProduto(String nomeProduto); // ✔️ correto

    List<Produto> findAll(); // ✔️ opcional, já vem do JpaRepository
}
