package com.sistema.sistema_contabil.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sistema.sistema_contabil.model.Municipios;

public interface MunicipiosRepository extends JpaRepository<Municipios, Long> {

    @Query("SELECT m FROM Municipios m " +
           "WHERE LOWER(m.nomeMun) LIKE LOWER(CONCAT('%', :filtro, '%')) " +
           "   OR CAST(m.codIbgeCompl AS string) LIKE CONCAT('%', :filtro, '%') " +
           "   OR LOWER(m.ufIbge) LIKE LOWER(CONCAT('%', :filtro, '%'))")
    Page<Municipios> buscarComFiltro(String filtro, Pageable pageable);

}
