package com.sistema.sistema_contabil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.sistema_contabil.model.Compras;
import com.sistema.sistema_contabil.repository.ComprasRepository;

@Service
public class ComprasService {

    @Autowired
    private ComprasRepository repository;

    public Compras salvar(Compras compra) throws JsonProcessingException {
        System.out.println("📦 *************************Dados COMPRA do front:***********************");
        System.out.println("📦 Dados recebidos do front:");
        //System.out.println(compra); // imprime o objeto
        //System.out.println("Cod da PJ: "+compra.getPessoaJuridica().getId());
        //System.out.println("Data da Compra: "+compra.getDataCompra()); 
        //System.out.println("Numero da NF: "+compra.getNumeroNota());
        //System.out.println("Serie da NF: " + compra.getSerieNota());
        //System.out.println("Itens: " + compra.getItens().get(0));
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(compra));



        // Vincula a compra nos itens
        compra.getItens().forEach(item -> item.setCompra(compra));
        return repository.save(compra);
    }

    public List<Compras> listarCompras() {
    List<Compras> compras = repository.findAll();

    System.out.println("🔵 Listando todas as compras salvas no banco:");
    compras.forEach(c -> {
        System.out.println("Compra ID: " + c.getId());
        System.out.println("Fornecedor: " + (c.getPessoaJuridica() != null ? c.getPessoaJuridica().getRazaoSocial() : "null"));
        System.out.println("Data: " + c.getDataCompra());
        System.out.println("Número NF: " + c.getNumeroNota());
        System.out.println("Série: " + c.getSerieNota());
        System.out.println("Valor Total: " + c.getValorTotal());
        System.out.println("----------");
    });

    return compras;
}


    public Compras buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }


    public Compras atualizarCompra(Long id, Compras novaCompra) {
    Compras existente = buscarPorId(id);
    if (existente == null) {
        return null;
    }

    existente.setDataCompra(novaCompra.getDataCompra());
    existente.setNumeroNota(novaCompra.getNumeroNota());
    existente.setSerieNota(novaCompra.getSerieNota());
    existente.setDescricaoNota(novaCompra.getDescricaoNota());
    existente.setValorDesconto(novaCompra.getValorDesconto());
    existente.setValorIcms(novaCompra.getValorIcms());
    existente.setValorTotal(novaCompra.getValorTotal());
    existente.setPessoaJuridica(novaCompra.getPessoaJuridica());

    // Zera os itens antigos e adiciona os novos
    existente.getItens().clear();
    novaCompra.getItens().forEach(item -> {
        item.setCompra(existente);
        existente.getItens().add(item);
    });

    try {
        return salvar(existente); // ✅ tratamento da exceção aqui
    } catch (JsonProcessingException e) {
        e.printStackTrace();
        return null;
    }
  }
}
