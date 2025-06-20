package com.sistema.sistema_contabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.sistema_contabil.model.Produtos;
import com.sistema.sistema_contabil.service.ProdutoService;

@RestController
@RequestMapping("/api")
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
    public Produtos salvar(@RequestBody Produtos dto) {
    return service.salvar(dto);

}


/* 
    @GetMapping("/buscar/{nome}")
    public ResponseEntity<Produtos> buscarPorNome(@PathVariable String nome) {
    return ResponseEntity.ok(service.buscarPorNome(nome));
}
*/

/* 
    // 🔹 Listar todas
    @GetMapping("/listar")
    public List<PessoaJuridicaDTO> listar() {
    
    List<PessoaJuridicaDTO> lista = service.listarTodos();
    
    return lista;

    }
*/


}



