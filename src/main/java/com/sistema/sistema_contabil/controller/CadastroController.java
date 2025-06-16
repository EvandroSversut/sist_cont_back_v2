package com.sistema.sistema_contabil.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.sistema_contabil.dto.PessoaJuridicaDTO;
import com.sistema.sistema_contabil.dto.PessoaUsuarioDTO;
import com.sistema.sistema_contabil.model.PessoaFisica;
import com.sistema.sistema_contabil.repository.PessoaFisicaRepository;
import com.sistema.sistema_contabil.repository.UsuarioRepository;
import com.sistema.sistema_contabil.service.CadastroService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

   
    @Autowired
    private PessoaFisicaRepository fisicaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
  // Teste de commit back



@PostMapping("/criar-usuario")
public ResponseEntity<?> cadastrar(@RequestBody PessoaUsuarioDTO dto) {
    try {
        // chama um service que cria Pessoa, PessoaFisica e Usuario
         System.out.println("***************Cadastro de novo usuario****************");
        System.out.println("ID PF: " + dto.getIdPessoaFisica());
        System.out.println("ID Usuario: " + dto.getIdUsuario());
        System.out.println("Nome: " + dto.getNome());
        System.out.println("Cpf: " + dto.getCpf());
        System.out.println("RG: " + dto.getRg());
        System.out.println("Telefone: " + dto.getTelefone());
        System.out.println("Rua: " + dto.getRua());
        System.out.println("Numero: " + dto.getNumero());
        System.out.println("Complemento: " + dto.getComplemento());
        System.out.println("Bairro: " + dto.getBairro());
        System.out.println("Cep: " + dto.getCep());
        System.out.println("Cidade: " + dto.getCidade());
        System.out.println("UF: " + dto.getUf());
        System.out.println("Email: " + dto.getEmail());
        System.out.println("Senha: " + dto.getSenha());
        cadastroService.cadastrarPessoaUsuario(dto);

        //return ResponseEntity.ok("Cadastro realizado com sucesso!");
        return ResponseEntity.ok(Map.of("mensagem", "Cadastro realizado com sucesso!"));

    } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

    // 🔹 Listar todas
    @GetMapping("/listar")
    public List<PessoaUsuarioDTO> listar() {
    
    List<PessoaUsuarioDTO> lista = cadastroService.listarTodos();
    
    return lista;
}




/* 
    @GetMapping("/listar")
    public List<PessoaFisica> listar() {
        List<PessoaFisica> lista = fisicaRepository.findAll();
        System.out.println("📜************** Lista de pessoas físicas:***************");
        //lista.forEach(p -> System.out.println(p));
        lista.forEach(p -> System.out.println("🔸 Nome: " + p.getNome() + 
                                              " | CPF: "  + p.getCpf() + 
                                              " | RG: "   + p.getRg() + 
                                              " | Telefone: " + p.getTelefone() + 
                                              " | Rua: "  + p.getRua() + 
                                              " | Numero: " + p.getNumero() + 
                                              " | Complem.: " + p.getComplemento() + 
                                              " | Bairro: " + p.getBairro() + 
                                              " | CEP: " + p.getCep() + 
                                              " | Cidade: " + p.getCidade() +
                                              " | UF: " + p.getUf() +
                                              " | Email: " + p.getEmail()
                                              ));
         System.out.println("***********************Fim da Lista********************");                                        
        return lista;
    }
*/

    @GetMapping("/listarr")
    public List<PessoaUsuarioDTO> listarComUsuario() {
       
    List<PessoaFisica> lista = fisicaRepository.findAll();

     //System.out.println("*************LISTAR PESSOAS************");

    //lista é a lista de PessoaFisica, que veio do banco
    // .stream() transforma essa lista em um "fluxo" (stream) de objetos PessoaFisica
    // .map(pf -> {...}) .map() é uma função de transformação.
    // Para cada PessoaFisica pf da lista, ele executa o bloco {...} e 
    // transforma esse pf em um novo objeto — nesse caso, um PessoaUsuarioDTO.
    List<PessoaUsuarioDTO> dtos = lista.stream().map(pf -> {
        
        PessoaUsuarioDTO dto = new PessoaUsuarioDTO();
        

        dto.setIdPessoaFisica(pf.getId());
        dto.setNome(pf.getNome());
        dto.setCpf(pf.getCpf());
        dto.setRg(pf.getRg());
        dto.setTelefone(pf.getTelefone());
        dto.setRua(pf.getRua());
        dto.setNumero(pf.getNumero());
        dto.setComplemento(pf.getComplemento());
        dto.setBairro(pf.getBairro());
        dto.setCep(pf.getCep());
        dto.setCidade(pf.getCidade());
        dto.setUf(pf.getUf());
        dto.setEmail(pf.getEmail());

        usuarioRepository.findByPessoaFisicaId(pf.getId())
                         .ifPresent(usuario -> dto.setIdUsuario(usuario.getId()));

        return dto;
    }).toList();

    return dtos;
}


       @PutMapping("/atualizar-usuario")
        public ResponseEntity<?> atualizar(@RequestBody PessoaUsuarioDTO dto) {
        System.out.println("📜****************   Metodo atualizar************************");
        System.out.println("📜****************Metodo atualizar************************");
        

        System.out.println("Id Pessoa Fisica: " + dto.getIdPessoaFisica());
        System.out.println("Id Usuario: " + dto.getIdUsuario());
        System.out.println("Nome: " + dto.getNome());
        System.out.println("Email: " + dto.getEmail());
        System.out.println("Senha: " + dto.getSenha());
        System.out.println("Telefone: " + dto.getTelefone());
        System.out.println("Rua: " + dto.getRua());
        System.out.println("Numero: " + dto.getNumero());
        System.out.println("Complemento: " + dto.getComplemento());
        System.out.println("Bairro: " + dto.getBairro());
        System.out.println("Cep: " + dto.getCep());
        System.out.println("Cidade: " + dto.getCidade());
        System.out.println("UF: " + dto.getUf());
        System.out.println("CPF: " + dto.getCpf());
        System.out.println("RG: " + dto.getRg());
        System.out.println("📜********Metodo atualizar agora vai p service***************");
        try {
        cadastroService.atualizarPessoaUsuario(dto);
        return ResponseEntity.ok("Atualização realizada com sucesso!");
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

     @GetMapping("/buscar")
    public List<PessoaFisica> buscar(@RequestParam String filtro) {
        return fisicaRepository.findByNomeContainingIgnoreCaseOrEmailContainingIgnoreCase(filtro, filtro);
    }

}
    

