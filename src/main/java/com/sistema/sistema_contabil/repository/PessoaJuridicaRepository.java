package com.sistema.sistema_contabil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.sistema_contabil.model.PessoaJuridica;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

      Optional<PessoaJuridica> findByCnpj(String cnpj);
      // Optional<> é usado para evitar null (boa prática).
      Optional<PessoaJuridica> findByRazaoSocial(String razaoSocial);

      boolean existsByCnpj(String cnpj);

      List<PessoaJuridica> findAll();
}

    
