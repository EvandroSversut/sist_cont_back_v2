package com.sistema.sistema_contabil.mapper;

import com.sistema.sistema_contabil.dto.PessoaUsuarioDTO;
import com.sistema.sistema_contabil.model.PessoaFisica;
import com.sistema.sistema_contabil.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CadastroMapper {

    @Mapping(target = "id", ignore = true)
        // Ignora o ID na criação
    PessoaFisica toPessoaFisica(PessoaUsuarioDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pessoaFisica", ignore = true)
        // A associação será feita no service
    Usuario toUsuario(PessoaUsuarioDTO dto);

    /**
     * Converte uma entidade Usuario (que contém uma PessoaFisica) em um DTO "achatado".
     *
     * @param usuario A entidade de origem.
     * @return O DTO preenchido.
     */
    @Mappings({
            // Mapeamentos do próprio Usuário
            @Mapping(source = "id", target = "idUsuario"),
            @Mapping(source = "email", target = "email"),
            @Mapping(target = "senha", ignore = true),

            // Mapeamentos da PessoaFisica associada
            @Mapping(source = "pessoaFisica.id", target = "idPessoaFisica"),
            @Mapping(source = "pessoaFisica.nome", target = "nome"),
            @Mapping(source = "pessoaFisica.cpf", target = "cpf"),
            @Mapping(source = "pessoaFisica.rg", target = "rg"),

            @Mapping(source = "pessoaFisica.telefone", target = "telefone"),
            @Mapping(source = "pessoaFisica.rua", target = "rua"),
            @Mapping(source = "pessoaFisica.numero", target = "numero"),
            @Mapping(source = "pessoaFisica.complemento", target = "complemento"),
            @Mapping(source = "pessoaFisica.bairro", target = "bairro"),
            @Mapping(source = "pessoaFisica.cep", target = "cep"),
            @Mapping(source = "pessoaFisica.cidade", target = "cidade"),
            @Mapping(source = "pessoaFisica.uf", target = "uf")
    })
    PessoaUsuarioDTO toPessoaUsuarioDTO(Usuario usuario);


    /**
     * Atualiza uma entidade PessoaFisica a partir de um DTO.
     *
     * @param dto          O DTO com os novos dados.
     * @param pessoaFisica A entidade existente que será atualizada.
     */
    @Mapping(target = "id", ignore = true)
    // Ignora o ID para não tentar atualizá-lo
    void updatePessoaFromDto(PessoaUsuarioDTO dto, @MappingTarget PessoaFisica pessoaFisica);


    /**
     * Atualiza uma entidade Usuario a partir de um DTO.
     *
     * @param dto     O DTO com os novos dados.
     * @param usuario A entidade existente que será atualizada.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "senha", ignore = true) // A senha é tratada com lógica separada
    @Mapping(target = "pessoaFisica", ignore = true) // Não atualiza a associação
    @Mapping(target = "acessos", ignore = true) // Não atualiza os acessos por este DTO
    @Mapping(target = "dataCriacao", ignore = true)
    // Não atualiza a data de criação
    void updateUsuarioFromDto(PessoaUsuarioDTO dto, @MappingTarget Usuario usuario);

}
