package com.sistema.sistema_contabil.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.sistema_contabil.dto.PessoaJuridicaDTO;
import com.sistema.sistema_contabil.model.PessoaJuridica;
import com.sistema.sistema_contabil.service.PessoaJuridicaService;

@RestController
@RequestMapping("/api/cnpj")
@CrossOrigin(origins = "http://localhost:4200")
public class JuridicaController {

    @Autowired
    private PessoaJuridicaService service;
    

    // 🔥 Fluxo Perfeito:
    // ✅ Front-end envia DTO → Controller recebe DTO.
    // 🔁 Controller → Service converte DTO para Entity, salva no banco, e retorna DTO.
    // 🗃️ Repository faz persistência no banco.
    // 🔄 Service converte Entity de volta em DTO para devolver ao front.

    @GetMapping("/{cnpj}")
    public ResponseEntity<PessoaJuridicaDTO> buscarCnpj(@PathVariable String cnpj){

        System.out.println("🔍 Buscando CNPJ: " + cnpj);

        //PessoaJuridica pj = service.buscarOuCriarPorCnpj(cnpj);

        return ResponseEntity.ok(service.buscarCnpj(cnpj));
    }

    @PostMapping("/salvar")
    public PessoaJuridicaDTO salvar(@RequestBody PessoaJuridicaDTO dto) {
    return service.salvar(dto);

}

/*
@GetMapping("/buscar/{nome}")
public ResponseEntity<List<PessoaJuridicaDTO>> buscar(@PathVariable String nome) {

    System.out.println("🔍 ******************************************");
    System.out.println("🔍 Controller: Buscando por Nome: " + nome);

    //return ResponseEntity.ok(service.buscarPorNome(nome));
}*/

@GetMapping("/buscar")
public ResponseEntity<Page<PessoaJuridicaDTO>> buscar(
        @RequestParam(required = false) String nome,
        @RequestParam int page,
        @RequestParam int size) {

            return ResponseEntity.ok(service.buscarPaginado(nome, page, size));
        }


    // 🔹 Listar todas
    @GetMapping("/listarPJ")
    public List<PessoaJuridicaDTO> listar() {
    
    List<PessoaJuridicaDTO> lista = service.listarTodos();
    
    return lista;
}

}
