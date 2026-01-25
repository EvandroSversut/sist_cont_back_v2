package com.sistema.sistema_contabil.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value; // Necessário para injetar valores
import org.springframework.stereotype.Service;

import com.sistema.sistema_contabil.controller.AcessoController;
import com.sistema.sistema_contabil.dto.NotaFiscalDTO;
import com.sistema.sistema_contabil.dto.NotaFiscalResumoDTO;
import com.sistema.sistema_contabil.mapper.NotaFiscalMapper;
import com.sistema.sistema_contabil.model.NotaFiscal;
import com.sistema.sistema_contabil.repository.AcessoRepository;
import com.sistema.sistema_contabil.repository.NotaFiscalRepository;
import com.sistema.sistema_contabil.repository.PessoaRepository;

import br.com.swconsultoria.certificado.CertificadoService;
import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.nfe.Nfe; // classe utilitária principal
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.DocumentoEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import br.com.swconsultoria.nfe.schema_4.consStatServ.TRetConsStatServ;
import jakarta.annotation.PostConstruct;
import java.io.File; // Para carregar o certificado e Para criar o diretório de logs


import jakarta.transaction.Transactional;

@Service
public class NotaFiscalService {

  
    private static final String DIR_LOG_NFE = "C:/nfe_logs_e_xmls"; // Diretório onde logs e XMLs serão salvos

    private final AcessoRepository acessoRepository;

    private final AcessoController acessoController;

    @Autowired 
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired 
    private PessoaRepository pessoaRepository;

    // ...
// Declarações dos @Value no topo da classe

    @Value("${nfe.certificado.caminho}")
    private String caminhoCertificado;

    @Value("${nfe.certificado.senha}")
    private String senhaCertificado;

    private ConfiguracoesNfe configNfe;


    // ...

    /**
     * MÉTODO DE INICIALIZAÇÃO DA NF-E (SamuelWeb)
     * Executado automaticamente após a inicialização do Spring Boot.
     */


@PostConstruct
private void inicializarNfe() {
    System.out.println("⏳ Inicializando Configurações da NF-e...");
    try {
        // apenas carrega config (não chama SEFAZ aqui)
        getConfigNfe();
        System.out.println("✅ Configuração carregada! (sem statusServico no startup)");

    } catch (Exception e) {
        System.err.println("⚠️ NF-e NÃO inicializada no startup. O sistema vai subir mesmo assim.");
        e.printStackTrace();

        // IMPORTANTE: NÃO derrubar a aplicação
        this.configNfe = null;
    }
}


private ConfiguracoesNfe getConfigNfe() throws Exception {
    if (this.configNfe != null) return this.configNfe;

    File baseDir = new File(DIR_LOG_NFE);
    if (!baseDir.exists()) baseDir.mkdirs();

    Certificado certificado = CertificadoService.certificadoPfx(
        caminhoCertificado,
        senhaCertificado
    );

    this.configNfe = ConfiguracoesNfe.criarConfiguracoes(
        EstadosEnum.SP,
        AmbienteEnum.HOMOLOGACAO,
        certificado,
        DIR_LOG_NFE
    );

    return this.configNfe;
}

public String testarStatusServico() throws Exception {
    TRetConsStatServ status = Nfe.statusServico(getConfigNfe(), DocumentoEnum.NFE);
    return status.getCStat() + " - " + status.getXMotivo();
}


    NotaFiscalService(AcessoController acessoController, AcessoRepository acessoRepository) {
        this.acessoController = acessoController;
        this.acessoRepository = acessoRepository;
    }

    // Criar/Salvar NotaFiscal
    @Transactional
    public NotaFiscalDTO salvar(NotaFiscalDTO dto){

         System.out.println("✅ Service - Recebendo NF-e do front (DTO).");

        // Usa o mapper para converter DTO -> Entity
        NotaFiscal entity = NotaFiscalMapper.toEntity(dto);

         // Salva no banco
        entity = notaFiscalRepository.save(entity);

        // Converte de volta Entity -> DTO (caso queira devolver no response)
        return NotaFiscalMapper.toDTO(entity);

       
                      
    }

      // Buscar por ID
    public Optional<NotaFiscalDTO> buscarPorId(Long id) {
        return notaFiscalRepository.findById(id)
                .map(NotaFiscalMapper::toDTO);
    }

     // Excluir por ID
    public void excluir(Long id) {
        notaFiscalRepository.deleteById(id);
    }
     
    @Transactional
    public void salvarNotaFiscalEstruturada(NotaFiscalDTO dto) {
        System.out.println("✅ Service - Recebendo NF-e do front (DTO).");
       // System.out.println("📘 Dados Gerais: " + dto.gerais);
        System.out.println("🧾 Emitente: " + dto.getEmitente());
        System.out.println("📦 Produtos: " + dto.getProdutos());
        System.out.println("👤 Destinatário: " + dto.getDestinatario());
        System.out.println("🚚 Transporte: " + dto.getTransporte());
        System.out.println("💵 Pagamento: " + dto.getPagamento());
        

    }

     public List<NotaFiscalResumoDTO> listarNotas() {
        return notaFiscalRepository.findAll().stream()
            .map(nota -> new NotaFiscalResumoDTO(
                nota.getId(),
                nota.getGeraisNfe().getNumeroNFe(),
                nota.getGeraisNfe().getSerie(),
                nota.getGeraisNfe().getDtHrEmissao() != null ? 
                    OffsetDateTime.parse(nota.getGeraisNfe().getDtHrEmissao()).toLocalDateTime() : null,
                nota.getDestinatario() != null ? nota.getDestinatario().getRazaoSocial() : "—",
                nota.getGeraisNfe().getVrTotalNfe(),
                "SALVA" // depois podemos mudar para status real
            ))
            .collect(Collectors.toList());
    }

    public NotaFiscal atualizarNota(Long id, NotaFiscalDTO dto) {
        Optional<NotaFiscal> optionalNota = notaFiscalRepository.findById(id);
        if (optionalNota.isEmpty()) {
            throw new RuntimeException("Nota Fiscal não encontrada para ID " + id);
        }

        NotaFiscal nota = optionalNota.get();

   
        return notaFiscalRepository.save(nota);
    }

    public void excluirNota(Long id) {
        if (!notaFiscalRepository.existsById(id)) {
            throw new RuntimeException("Nota Fiscal não encontrada para ID " + id);
        }
        notaFiscalRepository.deleteById(id);
    }


}



