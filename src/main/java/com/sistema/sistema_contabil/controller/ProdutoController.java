package com.sistema.sistema_contabil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.sistema_contabil.model.Produtos;
import com.sistema.sistema_contabil.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {

     @Autowired
    private ProdutoService service;

  
    // 🔥 Fluxo Perfeito:
    // ✅ Front-end envia DTO → Controller recebe DTO.
    // 🔁 Controller → Service converte DTO para Entity, salva no banco, e retorna DTO.
    // 🗃️ Repository faz persistência no banco.
    // 🔄 Service converte Entity de volta em DTO para devolver ao front.


    @PostMapping("/salvar")
    public Produtos salvar(@RequestBody Produtos produto) {
    return service.salvar(produto);

}


    // 🔍 Listar todos
    @GetMapping("/listar")
    public List<Produtos> listar() {
        return service.listar();
    }

        // 🔍 Buscar por ID
    @GetMapping("/buscar/{id}")
    public Produtos buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }


        // ❌ Deletar
    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        System.out.println("***************DELETAR****************");
        System.out.println("ID PF: " + id);
        service.deletar(id);
    }
}



