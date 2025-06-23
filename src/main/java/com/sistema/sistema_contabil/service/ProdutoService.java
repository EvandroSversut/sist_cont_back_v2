package com.sistema.sistema_contabil.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.sistema_contabil.model.Produtos;
import com.sistema.sistema_contabil.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(ProdutoService.class);

       // 🔸 Salvar
    public Produtos salvar(Produtos produto) {
              return repository.save(produto);
        
    }

        public List<Produtos> listar() {
        return repository.findAll();
    }

    // 🔸 Excluir
        public void deletar(Long id) {
        repository.deleteById(id);
           logger.info("************* EXCLUIR ************");
    }
    
        public Produtos buscarPorId(Long id) {
        Optional<Produtos> optional = repository.findById(id);
        return optional.orElse(null);
    }

   

}


