package com.sistema.sistema_contabil.service;

import com.sistema.sistema_contabil.dto.PessoaJuridicaDTO;
import com.sistema.sistema_contabil.model.PessoaJuridica;
import com.sistema.sistema_contabil.repository.PessoaJuridicaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(PessoaJuridicaService.class);

       // 🔸 Salvar
    public PessoaJuridicaDTO salvar(PessoaJuridicaDTO dto) {
        //👉 Aqui o converterParaEntity(dto) transforma o DTO que veio da API
        //    em uma entidade que o banco entende.
        PessoaJuridica entity = converterParaEntity(dto);
        System.out.println("🟢 Dados recebidos no DTO: " + dto);
        PessoaJuridica salvo = repository.save(entity);
        return converterParaDTO(salvo);
    }


/* 
     // 🔸 Listar todos
    public List<PessoaJuridicaDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());

                System.out.println("\n************* LISTA DE PESSOAS JURÍDICAS ************");
    lista.forEach(pj -> {
        System.out.println("-----------------------------------------------------");
        System.out.println("ID: " + pj.getId());
        System.out.println("CNPJ: " + pj.getCnpj());
        System.out.println("Razão Social: " + pj.getRazaoSocial());
        System.out.println("Nome Fantasia: " + pj.getNomeFantasia());
        System.out.println("Telefone: " + pj.getTelefone());
        System.out.println("Email: " + pj.getEmail());
        System.out.println("Endereço: " + pj.getRua() + ", " + pj.getNumero() + " - " + pj.getBairro());
        System.out.println("Cidade: " + pj.getCidade() + " - " + pj.getUf() + " | CEP: " + pj.getCep());
        System.out.println("-----------------------------------------------------\n");
    });

    return lista;
}

    }
*/

       public List<PessoaJuridicaDTO> listarTodos() {
        List<PessoaJuridicaDTO> lista = repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());

        logger.info("************* LISTAR PJ PESSOAS ************");
        
        //lista.forEach(pj -> logger.info(pj.toString()));
        lista.forEach(pj -> System.out.println(pj.imprimirBonito())); // este metodo esta no DTO


        return lista;
    }



   public PessoaJuridica buscarPorRazaoSocial(String nome) {
    return repository.findByRazaoSocial(nome)
            .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
}

/* 
    // 🔸 Buscar por ID
    public PessoaJuridicaDTO buscarPorId(Long id) {
        PessoaJuridica entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa Jurídica não encontrada"));
        return converterParaDTO(entity);
    } */

    /* 
    // 🔸 Criar ou atualizar
    public PessoaJuridicaDTO salvar(PessoaJuridicaDTO dto) {
        PessoaJuridica entity = converterParaEntidade(dto);
        entity = repository.save(entity);
        return converterParaDTO(entity);
    } */

    // 🔸 Excluir
    public void excluir(Long id) {
        repository.deleteById(id);
    }
    
    // 🔸 Conversor de Entity para DTO
    private PessoaJuridicaDTO converterParaDTO(PessoaJuridica entity) {
        PessoaJuridicaDTO dto = new PessoaJuridicaDTO();
        dto.setId(entity.getId());
        dto.setRazaoSocial(entity.getRazaoSocial());
        //dto.setNomeFantasia(entity.getNomeFantasia());
        dto.setCnpj(entity.getCnpj());
        dto.setInscEstadual(entity.getIe());
        //dto.setInscMunicipal(entity.getInscMunicipal());
        dto.setTelefone(entity.getTelefone());
        dto.setEmail(entity.getEmail());
        dto.setRua(entity.getRua());
        dto.setNumero(entity.getNumero());
        dto.setComplemento(entity.getComplemento());
        dto.setBairro(entity.getBairro());
        dto.setCep(entity.getCep());
        dto.setCidade(entity.getCidade());
        dto.setUf(entity.getUf());
        return dto;
    }

    // 🔸 Conversor DTO → Entity
    private PessoaJuridica converterParaEntity(PessoaJuridicaDTO dto) {
        PessoaJuridica entity = new PessoaJuridica();
        //entity.setId(dto.getId());
        entity.setCnpj(dto.getCnpj());
        entity.setRazaoSocial(dto.getRazaoSocial());
        //entity.setNomeFantasia(dto.getNomeFantasia());
        entity.setIe(dto.getInscEstadual());
        //entity.setInscMunicipal(dto.getInscMunicipal());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setRua(dto.getRua());
        entity.setNumero(dto.getNumero());
        entity.setComplemento(dto.getComplemento());
        entity.setBairro(dto.getBairro());
        entity.setCep(dto.getCep());
        entity.setCidade(dto.getCidade());
        entity.setUf(dto.getUf());
        return entity;
    }
    
    

}


