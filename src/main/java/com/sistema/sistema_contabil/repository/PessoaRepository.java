package com.sistema.sistema_contabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.sistema_contabil.model.PessoaJuridica;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<PessoaJuridica, Long> {
    Optional<PessoaJuridica> findByCnpj(String cnpj);
}
