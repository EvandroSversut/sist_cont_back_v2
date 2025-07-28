package com.sistema.sistema_contabil.controller;

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistema.sistema_contabil.dto.PessoaUsuarioDTO;
import com.sistema.sistema_contabil.model.PessoaFisica;
import com.sistema.sistema_contabil.repository.PessoaFisicaRepository;
import com.sistema.sistema_contabil.repository.UsuarioRepository;
import com.sistema.sistema_contabil.service.CadastroService;

@RestController
@RequestMapping("/api/cadastros") // Rota mais específica
public class CadastroController {

    private final CadastroService cadastroService;

    // Injeção via construtor, apenas do serviço orquestrador
    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @PostMapping("/usuario")
    public ResponseEntity<?> cadastrarNovoUsuario(@Valid @RequestBody PessoaUsuarioDTO dto) {
        // NENHUM try-catch, NENHUM System.out, NENHUMA lógica. Apenas delega.
        cadastroService.cadastrarPessoaUsuario(dto);
        return new ResponseEntity<>("Usuário criado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<PessoaUsuarioDTO>> listarTodos() {
        List<PessoaUsuarioDTO> lista = cadastroService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/pessoas/{pessoaId}/usuarios/{usuarioId}")
    public ResponseEntity<PessoaUsuarioDTO> atualizar(
            @PathVariable Long pessoaId,
            @PathVariable Long usuarioId,
            @Valid @RequestBody PessoaUsuarioDTO dto) {
        PessoaUsuarioDTO resultado = cadastroService.atualizarPessoaUsuario(pessoaId, usuarioId, dto);
        return ResponseEntity.ok(resultado);
    }
}

