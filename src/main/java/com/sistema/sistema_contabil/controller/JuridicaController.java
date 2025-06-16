package com.sistema.sistema_contabil.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.sistema_contabil.dto.PessoaJuridicaDTO;
import com.sistema.sistema_contabil.model.PessoaJuridica;
import com.sistema.sistema_contabil.repository.PessoaJuridicaRepository;
import com.sistema.sistema_contabil.service.PessoaJuridicaService;

@RestController
@RequestMapping("/api/pessoa-juridica")
@CrossOrigin(origins = "http://localhost:4200")
public class JuridicaController {

    @Autowired
    private PessoaJuridicaService service;

    @Autowired
    private PessoaJuridicaRepository pessoaRepo;

    // 🔥 Fluxo Perfeito:
    // ✅ Front-end envia DTO → Controller recebe DTO.
    // 🔁 Controller → Service converte DTO para Entity, salva no banco, e retorna DTO.
    // 🗃️ Repository faz persistência no banco.
    // 🔄 Service converte Entity de volta em DTO para devolver ao front.


    @PostMapping("/salvar")
    public PessoaJuridicaDTO salvar(@RequestBody PessoaJuridicaDTO dto) {
    return service.salvar(dto);

}

    @GetMapping("/buscar/{nome}")
    public ResponseEntity<PessoaJuridica> buscarPorRazaoSocial(@PathVariable String nome) {
    return ResponseEntity.ok(service.buscarPorRazaoSocial(nome));
}

    // 🔹 Listar todas
    @GetMapping("/listar")
    public List<PessoaJuridicaDTO> listar() {
    
    List<PessoaJuridicaDTO> lista = service.listarTodos();
    
    return lista;
}

  /* 
     // 🔹 Listar todas
    @GetMapping("/listar")
    public List<PessoaJuridicaDTO> listar() {
        System.out.println("*************LISTAR PJ PESSOAS************");
        return service.listarTodos();
    } */

    /* 
    @GetMapping("/listarrr")
    public List<PessoaJuridicaDTO> listarTodos() {

        List<PessoaJuridicaDTO> lista = pessoaRepo.findAll();

        System.out.println("*************LISTAR PESSOAS JURIDICAS************");

        List<PessoaJuridicaDTO> dtos = lista.stream().map(pj -> {

            PessoaJuridicaDTO dto = new PessoaJuridicaDTO();

           // dto.setIdPj(pj.getId());
            dto.setRazaoSocial(pj.getRazaoSocial());
            //dto.setNomeFantasia(pj.getNomeFantasia());
            dto.setCnpj(pj.getCnpj());
            //dto.setInscEstadual(pj.getInscricaoEstadual());
           // dto.setInscMunicipal(pj.getInscMunicipal());
            dto.setTelefone(pj.getTelefone());
            dto.setRua(pj.getRua());
            dto.setNumero(pj.getNumero());
            dto.setComplemento(pj.getComplemento());
            dto.setBairro(pj.getBairro());
            dto.setCep(pj.getCep());
            dto.setCidade(pj.getCidade());
            dto.setUf(pj.getUf());
            dto.setEmail(pj.getEmail());

            //pessoaRepo.findByDescricao(pj.getRazaoSocial());

            return dto;

        }).toList();

        return dtos;
  } */

}



