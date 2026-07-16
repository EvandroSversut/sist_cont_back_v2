package com.sistema.sistema_contabil.mapper;

import com.sistema.sistema_contabil.dto.PessoaUsuarioDTO;
import com.sistema.sistema_contabil.model.pessoa.PessoaFisica;
import com.sistema.sistema_contabil.model.pessoa.Usuario;

public class PessoaUsuarioMapper {

    public static PessoaFisica toPessoaFisica(PessoaUsuarioDTO dto) {

        PessoaFisica pf = new PessoaFisica();

        pf.setNome(dto.getNome());
        pf.setCpf(dto.getCpf());
        pf.setRg(dto.getRg());
        pf.setTelefone1(dto.getTelefone1());
        pf.setRua(dto.getRua());
        pf.setNumero(dto.getNumero());
        pf.setComplemento(dto.getComplemento());
        pf.setBairro(dto.getBairro());
        pf.setCep(dto.getCep());
        pf.setCidade(dto.getCidade());
        pf.setUf(dto.getUf());

        return pf;
    }

    public static Usuario toUsuario(PessoaUsuarioDTO dto, PessoaFisica pf) {

        Usuario usuario = new Usuario();

        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha()); // criptografa no service
        usuario.setPessoa(pf);

        return usuario;
    }
}