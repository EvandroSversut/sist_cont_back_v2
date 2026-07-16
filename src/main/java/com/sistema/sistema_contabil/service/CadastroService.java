package com.sistema.sistema_contabil.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.sistema_contabil.dto.PessoaUsuarioDTO;
import com.sistema.sistema_contabil.model.pessoa.PessoaFisica;
import com.sistema.sistema_contabil.model.pessoa.Usuario;
import com.sistema.sistema_contabil.repository.PessoaFisicaRepository;
import com.sistema.sistema_contabil.repository.UsuarioRepository;


@Service
public class CadastroService {

    private static final Logger logger = LoggerFactory.getLogger(PessoaJuridicaService.class);

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioService usuarioService;

    public void cadastrarPessoaUsuario(PessoaUsuarioDTO dto) {

    System.out.println("****************Cadastro de PF - Service*****************");
    // 🔹 Cadastrar Pessoa Física 
    PessoaFisica pessoaFisica = new PessoaFisica();
    pessoaFisica.setNome(dto.getNome());
    pessoaFisica.setTelefone1(dto.getTelefone1());
    pessoaFisica.setRua(dto.getRua());
    pessoaFisica.setNumero(dto.getNumero());
    pessoaFisica.setComplemento(dto.getComplemento());
    pessoaFisica.setBairro(dto.getBairro());
    pessoaFisica.setCep(dto.getCep());
    pessoaFisica.setCidade(dto.getCidade());
    pessoaFisica.setUf(dto.getUf());

    pessoaFisica.setCpf(dto.getCpf());
    pessoaFisica.setRg(dto.getRg());

    pessoaFisica = pessoaFisicaRepo.save(pessoaFisica);
    System.out.println("Salvo PessoaFisica: " + pessoaFisica.getId());

    System.out.println("**********Agora cadastrar Usuario**********************");
    System.out.println("Usuário com ID PF a salvar: " + pessoaFisica.getId());
    // 🔹 Cadastrar Usuário
    Usuario usuario = new Usuario();
    usuario.setEmail(dto.getEmail()); // pode ser igual ao da pessoa física
    usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
    usuario.setPessoa(pessoaFisica); // associa corretamente
    usuario.setDataCriacao(usuario.getDataCriacao());
    usuario.isAtivo();
    
    // Chama o método que já cuida de adicionar o ROLE_USER
    System.out.println("**************Chama o Cadastro de Usuario no Service*******************");
    //System.out.println("Usuario --->> " + pessoaFisica.getId());
    System.out.println("Usuario ----> " + usuario);

    System.out.println("📥 Preparando para salvar o usuário:");

        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Senha (criptografada): " + usuario.getSenha());
        System.out.println("Pessoa Física: " + (usuario.getPessoa().getId()));
        System.out.println("Ativo: " + usuario.isAtivo());
        System.out.println("Data Criação: " + usuario.getDataCriacao());

    // Aqui salva um novo usuario "ROLE_USER"
    usuarioService.cadastrarUsuario(usuario);

    System.out.println("Usuário salvo com ID: " + usuario.getId());
}
    
    public void atualizarPessoaUsuario(PessoaUsuarioDTO dto) {
    // 🔍 Busca PessoaFisica existente
    PessoaFisica pessoaFisica = pessoaFisicaRepo.findById(dto.getIdPessoaFisica())
        .orElseThrow(() -> new RuntimeException("Pessoa física não encontrada"));
  
    pessoaFisica.setNome(dto.getNome());
    //pessoaFisica.setEmail(dto.getEmail());
    pessoaFisica.setTelefone1(dto.getTelefone1());
    pessoaFisica.setRua(dto.getRua());
    pessoaFisica.setNumero(dto.getNumero());
    pessoaFisica.setComplemento(dto.getComplemento());
    pessoaFisica.setBairro(dto.getBairro());
    pessoaFisica.setCep(dto.getCep());
    pessoaFisica.setCidade(dto.getCidade());
    pessoaFisica.setUf(dto.getUf());
    pessoaFisica.setCpf(dto.getCpf());
    pessoaFisica.setRg(dto.getRg());
    

    pessoaFisicaRepo.save(pessoaFisica);

    // 🔍 Busca Usuario existente
    Usuario usuario = usuarioRepo.findById(dto.getIdUsuario())
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    usuario.setEmail(dto.getEmail());

    if (dto.getSenha() != null && !dto.getSenha().isBlank()) {
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
    }

    usuario.setPessoa(pessoaFisica);
    usuario.setAtivo(true); // ou dto.isAtivo() se quiser controlar isso no front

    usuarioRepo.save(usuario);
}
    
        public List<PessoaUsuarioDTO> listarTodos() {
        List<Usuario> usuarios = usuarioRepo.findAll();

        List<PessoaUsuarioDTO> lista = usuarios.stream()
            .map(usuario -> converterParaDTO((PessoaFisica)usuario.getPessoa(), usuario))
            .collect(Collectors.toList());

        lista.forEach(dto -> System.out.println(dto.imprimirBonito()));

        return lista;
    }

     // 🔸 Conversor de Entity para DTO
    private PessoaUsuarioDTO converterParaDTO(PessoaFisica pessoaFisica, Usuario usuario) {
        PessoaUsuarioDTO dto = new PessoaUsuarioDTO();
        
        dto.setIdPessoaFisica(pessoaFisica.getId());
        dto.setNome(pessoaFisica.getNome());
        dto.setCpf(pessoaFisica.getCpf());
        dto.setRg(pessoaFisica.getRg());
        dto.setTelefone1(pessoaFisica.getTelefone1());
        dto.setRua(pessoaFisica.getRua());
        dto.setNumero(pessoaFisica.getNumero());
        dto.setComplemento(pessoaFisica.getComplemento());
        dto.setBairro(pessoaFisica.getBairro());
        dto.setCep(pessoaFisica.getCep());
        dto.setCidade(pessoaFisica.getCidade());
        dto.setUf(pessoaFisica.getUf());

        dto.setIdUsuario(usuario.getId());
        dto.setEmail(usuario.getEmail());
        dto.setSenha(usuario.getSenha());

        return dto;
    }


}


        /*teste */




  

        /*teste */





    /*
            // 🔹 Cadastrar Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoa.setTelefone(dto.getTelefone());
        pessoa.setRua(dto.getRua());
        pessoa.setNumero(dto.getNumero());
        pessoa.setBairro(dto.getBairro());
        pessoa.setComplemento(dto.getComplemento());
        pessoa.setCep(dto.getCep());
        pessoa.setCidade(dto.getCidade());
        pessoa.setUf(dto.getUf());

        pessoa = pessoaRepo.save(pessoa);

        // 🔹 Cadastrar Pessoa Física
        PessoaFisica pessoaFisica = new PessoaFisica();
        System.out.println("Cpf: " + dto.getCpf());
        System.out.println("RG: " + dto.getRg());
               
        pessoaFisica.setCpf(dto.getCpf());
        pessoaFisica.setRg(dto.getRg());
      
        pessoaFisica = pessoaFisicaRepo.save(pessoaFisica);

        // 🔹 Cadastrar Usuário
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setPessoaFisica(pessoaFisica);

        usuarioRepo.save(usuario);
    }
    */
