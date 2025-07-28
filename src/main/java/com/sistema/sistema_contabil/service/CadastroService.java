package com.sistema.sistema_contabil.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sistema.sistema_contabil.mapper.CadastroMapper;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sistema.sistema_contabil.dto.PessoaUsuarioDTO;
import com.sistema.sistema_contabil.model.PessoaFisica;
import com.sistema.sistema_contabil.model.Usuario;


@Service
public class CadastroService {

    // Logger corrigido para a classe certa
    private static final Logger logger = LoggerFactory.getLogger(CadastroService.class);

    // Injeção dos SERVIÇOS especializados, não dos repositórios
    private final PessoaFisicaService pessoaFisicaService;
    private final UsuarioService usuarioService;
    private final CadastroMapper mapper;

    // Injeção de dependências via construtor (melhor prática)
    public CadastroService(PessoaFisicaService pessoaFisicaService, UsuarioService usuarioService, CadastroMapper mapper) {
        this.pessoaFisicaService = pessoaFisicaService;
        this.usuarioService = usuarioService;
        this.mapper = mapper;
    }

    /**
     * Orquestra o cadastro completo de uma Pessoa e seu Usuário associado.
     * A anotação @Transactional garante que ou tudo funciona, ou nada é salvo.
     */
    @Transactional
    public void cadastrarPessoaUsuario(PessoaUsuarioDTO dto) {
        logger.info("Iniciando processo de cadastro para o CPF: {}", dto.getCpf());

        // 1. Mapear e Salvar PessoaFisica
        PessoaFisica pessoaFisica = mapper.toPessoaFisica(dto);
        PessoaFisica pessoaSalva = pessoaFisicaService.save(pessoaFisica);
        logger.debug("Pessoa Física salva com ID: {}", pessoaSalva.getId());

        // 2. Mapear, Associar e Salvar Usuario
        Usuario usuario = mapper.toUsuario(dto);
        usuario.setPessoaFisica(pessoaSalva); // Associa a pessoa recém-salva

        // 3. DELEGAR a criação do usuário para o service que sabe as regras de negócio
        Usuario usuarioSalvo = usuarioService.save(usuario);
        logger.info("Cadastro completo para o usuário com ID: {} e Pessoa Física com ID: {}", usuarioSalvo.getId(), pessoaSalva.getId());

        // 4. Retornar um DTO completo com os dados salvos
        mapper.toPessoaUsuarioDTO(usuarioSalvo);
    }

    /**
     * Lista todos os usuários e suas informações de pessoa física associadas.
     */
    public List<PessoaUsuarioDTO> listarTodos() {
        logger.info("Buscando todos os usuários para listagem completa.");
        return usuarioService.findAll().stream()
                .map(mapper::toPessoaUsuarioDTO) // Usa o mapper para converter cada um
                .collect(Collectors.toList());
    }

    /**
     * Orquestra a atualização de uma Pessoa e seu Usuário.
     */
    @Transactional
    public PessoaUsuarioDTO atualizarPessoaUsuario(Long pessoaId, Long usuarioId, PessoaUsuarioDTO dto) {
        logger.info("Iniciando processo de atualização para Pessoa ID: {} e Usuário ID: {}", pessoaId, usuarioId);

        // 1. Busca as entidades existentes. Nosso BaseServiceImpl já lança exceção se não encontrar.
        Optional<PessoaFisica> pfExistente = pessoaFisicaService.findById(pessoaId);
        Optional<Usuario> usuarioExistente = usuarioService.findById(usuarioId);

        // 2. USA O MAPPER PARA ATUALIZAR AS ENTIDADES EM MEMÓRIA
        // O MapStruct faz todo o trabalho de "setar" os campos para nós.
        mapper.updatePessoaFromDto(dto, pfExistente.orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + pessoaId)));
        mapper.updateUsuarioFromDto(dto, usuarioExistente.orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + usuarioId)));
        logger.debug("Entidades PessoaFisica e Usuario atualizadas em memória a partir do DTO.");

        // 3. LÓGICA DE NEGÓCIO ESPECÍFICA (que não pertence ao mapper)
        // A atualização de senha é uma regra de negócio separada e sensível.
        if (dto.getSenha() != null && !dto.getSenha().isBlank()) {
            logger.info("Senha fornecida para o usuário ID: {}. Solicitando atualização.", usuarioId);
            // Supondo que você crie este método no UsuarioService para encapsular a lógica
            usuarioService.atualizarSenha(usuarioId, dto.getSenha());
        }

        // 4. PERSISTIR AS MUDANÇAS NO BANCO
        // Como o método é @Transactional, o próprio Spring/JPA já salvaria as
        // alterações no final da transação, mas chamar o save() é explícito e seguro.
        pessoaFisicaService.save(pfExistente.get());
        Usuario usuarioAtualizado = usuarioService.save(usuarioExistente.get());
        logger.info("Atualização persistida no banco de dados com sucesso.");

        // 5. Retorna o DTO com os dados atualizados
        return mapper.toPessoaUsuarioDTO(usuarioAtualizado);
    }
}


