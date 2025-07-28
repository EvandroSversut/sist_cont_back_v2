package com.sistema.sistema_contabil.generics;

import java.util.List;

/**
 * Interface genérica para definir um contrato padrão para conversores.
 *
 * @param <D> - O tipo do DTO (Data Transfer Object)
 * @param <E> - O tipo da Entidade (Entity)
 */
public interface BaseMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);
}
