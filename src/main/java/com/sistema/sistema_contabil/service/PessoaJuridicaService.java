package com.sistema.sistema_contabil.service;

import com.sistema.sistema_contabil.dto.BrasilApiDTO;
import com.sistema.sistema_contabil.dto.PessoaJuridicaDTO;
import com.sistema.sistema_contabil.mapper.PessoaJuridicaMapper;
import com.sistema.sistema_contabil.model.PessoaJuridica;
import com.sistema.sistema_contabil.repository.PessoaJuridicaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository repository;

    @Autowired
    private BrasilApiService brasilApiService;

    @Autowired
    private PessoaJuridicaMapper mapper;

    public PessoaJuridicaDTO buscarCnpj(String cnpj) {

    System.out.println("🏢 Verificando se CNPJ já existe no banco...");

    Optional<PessoaJuridica> existente = repository.findByCnpj(cnpj);

    // 🟣 CASO EXISTENTE
    if (existente.isPresent()) {

        PessoaJuridicaDTO dto = mapper.toDTO(existente.get());

        dto.setTipo("EXISTENTE");
        dto.setMensagem("CNPJ já cadastrato");

        return dto;
    }

     // 🔵 CASO NOVO (BrasilAPI)
     
    System.out.println("🌐 CNPJ não encontrado. Consultando BrasilAPI...");

    BrasilApiDTO api = brasilApiService.consultarCnpj(cnpj);

    PessoaJuridicaDTO dto = mapper.fromBrasilApi(api);

    dto.setTipo("NOVO");

    return dto;

}

    private static final Logger logger = LoggerFactory.getLogger(PessoaJuridicaService.class);

       // 🔸 Salvar
    public PessoaJuridicaDTO salvar(PessoaJuridicaDTO dto) {

        logger.info("🟢 Recebendo DTO: {}", dto);

        //👉 Aqui o converterParaEntity(dto) transforma o DTO que veio da API
        //    em uma entidade que o banco entende.
        PessoaJuridica entity = mapper.toEntity(dto);

        System.out.println("🟢 Dados recebidos no DTO: " + dto);

        PessoaJuridica salvo = repository.save(entity);

          // ✅ converter de volta usando mapper
        return mapper.toDTO(salvo);
    }

    public List<PessoaJuridicaDTO> listarTodos() {

        List<PessoaJuridicaDTO> lista = repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        logger.info("************* LISTAR PJ PESSOAS ************");
        
        //lista.forEach(pj -> logger.info(pj.toString()));
        lista.forEach(pj -> System.out.println(pj.imprimirBonito())); // este metodo esta no DTO

        return lista;
    }

  /*   public List<PessoaJuridicaDTO> buscarPorNome(String nome) {

        System.out.println("🔍 Service: Buscando por Nome: " + nome);
    return repository.findByRazaoSocialContainingIgnoreCase(nome)
            .stream()
            .map(mapper::toDTO)
            .toList();
}*/


public Page<PessoaJuridicaDTO> buscarPaginado(String nome, int page, int size) {

    System.out.println("🔍 NOME: " + nome);
    System.out.println("📄 PAGE: " + page + " SIZE: " + size);

    PageRequest pageable = PageRequest.of(page, size);

    Page<PessoaJuridica> resultado;

    if (nome == null || nome.isEmpty()) {
        resultado = repository.findAll(pageable);
    } else {
        resultado = repository.findByRazaoSocialContainingIgnoreCase(nome, pageable);
    }

    System.out.println("📦 TOTAL REGISTROS: " + resultado.getTotalElements());

    resultado.getContent().forEach(pj -> {
        System.out.println("➡️ " + pj.getRazaoSocial()
            + " | IE : " + pj.getIe()
            + " | EMAIL: " + pj.getEmailContato()
            + " | TEL: " + pj.getTelefone1());
    });

    return resultado.map(mapper::toDTO);
}
    


   public PessoaJuridica buscarPorRazaoSocial(String nome) {
    return repository.findByRazaoSocial(nome)
            .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
}

    // 🔸 Excluir
    public void excluir(Long id) {
        repository.deleteById(id);
    }
    
       

}


