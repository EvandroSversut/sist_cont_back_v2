package com.sistema.sistema_contabil.generics;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// T -> Tipo da Entidade (ex: PessoaFisica)
// ID -> Tipo do ID da Entidade (ex: Long)
// R -> Tipo do Repositório (ex: PessoaFisicaRepository)
public abstract class BaseServiceImpl<T, ID, R extends JpaRepository<T, ID>> implements BaseService<T, ID> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected final R repository;

    protected BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        logger.info("Salvando entidade do tipo {}", entity.getClass().getSimpleName());
        T savedEntity = repository.save(entity);
        logger.info("Entidade salva com sucesso com ID: {}", savedEntity.toString());
        return savedEntity;
    }

    @Override
    public Optional<T> findById(ID id) {
        logger.info("Buscando entidade pelo ID: {}", id);
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Entidade com ID: {} não encontrada.", id);
                    return new EntityNotFoundException("Recurso não encontrado com ID: " + id);
                }));
    }

    @Override
    public List<T> findAll() {
        logger.info("Buscando todas as entidades.");
        return repository.findAll();
    }

    @Override
    public void deleteById(ID id) {
        logger.info("Deletando entidade pelo ID: {}", id);
        if (!repository.existsById(id)) {
            logger.warn("Tentativa de deletar entidade inexistente com ID: {}", id);
            throw new EntityNotFoundException("Recurso não encontrado com ID: " + id);
        }
        repository.deleteById(id);
        logger.info("Entidade com ID: {} deletada com sucesso.", id);
    }

}
