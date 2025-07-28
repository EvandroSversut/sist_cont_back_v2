package com.sistema.sistema_contabil.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sistema.sistema_contabil.generics.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.sistema_contabil.model.Acesso;
import com.sistema.sistema_contabil.model.Usuario;
import com.sistema.sistema_contabil.repository.AcessoRepository;
import com.sistema.sistema_contabil.repository.UsuarioRepository;

import jakarta.transaction.Transactional;


@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

    private final AcessoRepository acessoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    protected UsuarioService(UsuarioRepository repository, AcessoRepository acessoRepository) {
        super(repository);
        this.acessoRepository = acessoRepository;
    }

    public Usuario save(Usuario usuario) {

        System.out.println("********Usuario Service: Salva o acesso padrão (ROLE_USER)");


        /* "Se o usuário não tiver nenhum perfil de acesso atribuído
        (ex: ADMIN, USER, etc), então automaticamente atribua o perfil ROLE_USER, 
        que é o padrão mínimo para qualquer usuário comum do sistema."*/

        // Define acesso padrão se o usuário não tiver nenhum acesso
        if (usuario.getAcessos() == null || usuario.getAcessos().isEmpty()) {
            System.out.println("🛡️ Nenhum acesso foi atribuído ao usuário. Definindo acesso padrão...");
            // Busca o acesso com a descrição "ROLE_USER" no banco de dados
            Acesso acessoUser = acessoRepository.findByDescricao("ROLE_USER")
                    // Se não encontrar, lança uma exceção
                    .orElseThrow(() -> new RuntimeException("Acesso ROLE_USER não encontrado"));
            System.err.println("❌ Acesso ROLE_USER não encontrado no banco!");
            // Define a lista de acessos do usuário com apenas o acesso "ROLE_USER"

            usuario.setAcessos(List.of(acessoUser));
            System.out.println("✅ Acesso ROLE_USER encontrado: " + acessoUser.getDescricao());
            System.out.println("🔐 Acesso ROLE_USER atribuído ao usuário: " + usuario.getEmail());
        } else {
            System.out.println("✅ Usuário já possui acessos: " + usuario.getAcessos());
        }

        usuario.setDataCriacao(LocalDateTime.now());
        usuario.setAtivo(true);

        // 🔍 PRINTS DETALHADOS:
        System.out.println("📥 Preparando para salvar o usuário:");
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Senha (criptografada): " + usuario.getSenha());
        System.out.println("Pessoa Física: " + (usuario.getPessoaFisica() != null ? usuario.getPessoaFisica().getNome() : "null"));
        System.out.println("Acessos:");
        usuario.getAcessos().forEach(a -> System.out.println("🔑 " + a.getDescricao()));
        System.out.println("Ativo: " + usuario.isAtivo());
        System.out.println("Data Criação: " + usuario.getDataCriacao());

        return repository.save(usuario);
    }


    public List<Usuario> listarUsuariosAtivos() {
        return repository.findAll()
                .stream()
                .filter(Usuario::isAtivo)
                .collect(Collectors.toList());

        // Você pode trocar esse filtro por uma consulta direta ao banco, se preferir mais performance:
        //  @Query("SELECT u FROM Usuario u WHERE u.ativo = true")
        //  List<Usuario> findUsuariosAtivos();

    }

    @Transactional
    public void desativarUsuario(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setAtivo(false);
        repository.save(usuario);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }

    /**
     * Atualiza a senha de um usuário de forma segura, garantindo a criptografia.
     *
     * @param usuarioId O ID do usuário a ter a senha atualizada.
     * @param novaSenha A nova senha em texto plano.
     */
    @Transactional
    public void atualizarSenha(Long usuarioId, String novaSenha) {
        logger.info("Iniciando atualização de senha para o usuário ID: {}", usuarioId);
        // 1. Busca o usuário ou lança uma exceção se não encontrado
        Usuario usuario = this.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + usuarioId));
        ;

        // 2. Criptografa a nova senha antes de salvar
        String senhaCriptografada = passwordEncoder.encode(novaSenha);
        usuario.setSenha(senhaCriptografada);

        super.save(usuario);

        logger.info("Senha para o usuário ID: {} foi atualizada com sucesso.", usuarioId);
    }

}







