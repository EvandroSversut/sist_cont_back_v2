package com.sistema.sistema_contabil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.sistema_contabil.model.Compras;
import com.sistema.sistema_contabil.repository.ComprasRepository;

@Service
public class ComprasService {

    @Autowired
    private ComprasRepository repository;

    public Compras salvar(Compras compra) {
        // Vincula a compra nos itens
        compra.getItens().forEach(item -> item.setCompra(compra));
        return repository.save(compra);
    }

    public List<Compras> listarCompras() {
        return repository.findAll();
    }

    public Compras buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
