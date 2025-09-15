package com.sistema.sistema_contabil.service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.sistema_contabil.controller.AcessoController;
import com.sistema.sistema_contabil.dto.NotaFiscalDTO;
import com.sistema.sistema_contabil.dto.NotaFiscalResumoDTO;
import com.sistema.sistema_contabil.model.GeraisNfe;
import com.sistema.sistema_contabil.model.ItemNotaFiscal;
import com.sistema.sistema_contabil.model.NotaFiscal;
import com.sistema.sistema_contabil.model.Pagamento;
import com.sistema.sistema_contabil.model.PessoaJuridica;
import com.sistema.sistema_contabil.model.Transporte;
import com.sistema.sistema_contabil.repository.AcessoRepository;
import com.sistema.sistema_contabil.repository.NotaFiscalRepository;
import com.sistema.sistema_contabil.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class NotaFiscalService {

    private final AcessoRepository acessoRepository;

    private final AcessoController acessoController;

    @Autowired 
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired 
    private PessoaRepository pessoaRepository;


    NotaFiscalService(AcessoController acessoController, AcessoRepository acessoRepository) {
        this.acessoController = acessoController;
        this.acessoRepository = acessoRepository;
    }

    
        /**
     * Salva uma nota fiscal completa, estruturada com dados de emitente, destinatário,
     * itens (produtos), transporte, pagamento e dados gerais da NF-e.
     *
     * @param dto Objeto NotaFiscalDTO contendo todos os dados da nota fiscal recebidos do front-end.
     */
    @Transactional
    public void salvarNotaFiscalEstruturada(NotaFiscalDTO dto) {
        System.out.println("✅ Service - Recebendo NF-e do front (DTO).");
        System.out.println("📘 Dados Gerais: " + dto.gerais);
        System.out.println("🧾 Emitente: " + dto.getEmitente());
        System.out.println("📦 Produtos: " + dto.getProdutos());
        System.out.println("👤 Destinatário: " + dto.getDestinatario());
        System.out.println("🚚 Transporte: " + dto.getTransporte());
        System.out.println("💵 Pagamento: " + dto.getPagamento());
        
        try {
        ObjectMapper mapper = new ObjectMapper();
        String jsonDTO = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
        System.out.println("🔍 Dados recebidos do front-end (DTO):\n" + jsonDTO);
    

        // 🔎 Busca o emitente pelo CNPJ informado no DTO. Se não existir, lança exceção.
        PessoaJuridica emitente = pessoaRepository.findByCnpj(dto.emitente.cnpj)
        .orElseThrow(() -> new RuntimeException("Emitente não encontrado com CNPJ: " + dto.emitente.cnpj));

        // 🔎 Busca o destinatário pelo CNPJ informado no DTO. Se não existir, lança exceção.
        PessoaJuridica destinatario = pessoaRepository.findByCnpj(dto.destinatario.cnpj)
        .orElseThrow(() -> new RuntimeException("Destinatário não encontrado com CNPJ: " + dto.destinatario.cnpj));

        // Dados de pagamento
        Pagamento pagamento = new Pagamento();
        pagamento.setFormaPagamento(dto.pagamento.formaPagamento);
        pagamento.setValorPago(dto.pagamento.valorPago);
        pagamento.setValorTroco(dto.pagamento.valorTroco);

        // Dados de transporte
        Transporte transporte = new Transporte();
        transporte.setModFrete(dto.transporte.modFrete);
        transporte.setTransportadora(dto.transporte.transportadora);
        transporte.setCnpjTransportadora(dto.transporte.cnpjTransportadora);
        transporte.setPlacaVeiculo(dto.transporte.placaVeiculo);
        transporte.setUfPlaca(dto.transporte.ufPlaca);
        //transporte.setValorFrete(dto.transporte.valor_frete);

        GeraisNfe gerais = new GeraisNfe();
       
        gerais.setLayout(dto.gerais.layout);
        gerais.setIdChaveAcesso(dto.gerais.idChaveAcesso);
        gerais.setUfEmitente(dto.gerais.ufEmitente);
        gerais.setCodNumericoNFe(dto.gerais.codNumericoNFe);
        gerais.setNatOperacao(dto.gerais.natOperacao);
        gerais.setCrt(dto.gerais.crt);
        gerais.setSerie(dto.gerais.serie);
        gerais.setNumeroNFe(dto.gerais.numeroNFe);
        gerais.setDtHrEmissao(dto.gerais.dtHrEmissao);
        gerais.setDtHrSaida(dto.gerais.dtHrSaida);
        gerais.setTipo(dto.gerais.tipo);
        gerais.setDestinoOpe(dto.gerais.destinoOpe);
        gerais.setIbge(dto.gerais.ibge);
        gerais.setFormatoDanfe(dto.gerais.formatoDanfe);
        gerais.setTipoEmissao(dto.gerais.tipoEmissao);
        gerais.setDigitoChave(dto.gerais.digitoChave);
        gerais.setAmbiente(dto.gerais.ambiente);
        gerais.setFinalidade(dto.gerais.finalidade);
        gerais.setConsumidorFinal(dto.gerais.consumidorFinal);
        gerais.setVendaPresencial(dto.gerais.vendaPresencial);
        gerais.setProcessoVersaoEmissor(dto.gerais.processoVersaoEmissor);
        gerais.setVendaPresencial(dto.gerais.vendaPresencial);
        gerais.setBaseCalculo(dto.gerais.baseCalculo);
        gerais.setVrIcms(dto.gerais.vrIcms);
        gerais.setVrTotalProd(dto.gerais.vrTotalProd);
        gerais.setVrTotalNfe(dto.gerais.vrTotalNfe);

     
         // Criar nota fiscal
        NotaFiscal nota = new NotaFiscal();
        /* Explicaçao: exemplo Emitente: como na entity NotaFiscal está anotado como ManyToOne
         * o objeto PessoaJuridica passado no setEmitente() já tem um id preenchido
         * e o JPA entende que se o objeto tem ID, ele já existe no banco, entao nao deve
         * ser recriado, so referenciado
         * ✔️ Ou seja, ele não copia os dados do emitente e destinatário para a nota, 
         * apenas vincula os IDs já existentes
          */
        nota.setGeraisNfe(gerais);
        nota.setEmitente(emitente);
        nota.setDestinatario(destinatario);
        nota.setTransportadora(transporte);
        nota.setPagamento(pagamento);
       
     // Montar lista de itens
     // 📆 Converte a lista de ProdutoDTO em lista de ItemNotaFiscal vinculando com a nota.
    /*  dto.produtos.stream() — cria um stream (fluxo) de elementos da lista produtos (cada elemento é um ProdutoDTO).
        .map(p -> { ... }) — para cada ProdutoDTO p executa a função lambda:
            new ItemNotaFiscal() — cria uma nova instância da entidade que vai ser salva no banco.
            item.setXxx(p.getXxx()) — copia valores do DTO para a entidade (conversão DTO → entidade).
            return item; — o map transforma o ProdutoDTO em ItemNotaFiscal.
        .collect(Collectors.toList()) — reúne todos os ItemNotaFiscal produzidos pelo map numa List<ItemNotaFiscal>.
       */
        List<ItemNotaFiscal> itens = dto.produtos.stream().map(p -> {
    ItemNotaFiscal item = new ItemNotaFiscal();
    item.setCodProd(p.getCodProd());
    item.setDescricao(p.getDescricao());
    item.setCodBarras(p.getCodBarras());
    item.setNcm(p.getNcm());
    item.setProdutoST(p.getProdutoST());
    item.setCst(p.getCst());
    item.setCsosn(p.getCsosn());
    item.setCfop(p.getCfop());
    item.setUnidade(p.getUnidade());
    item.setQuantidade(p.getQuantidade());
    item.setValorUnitario(p.getValorUnitario());
    item.setDesconto(p.getDesconto());
    item.setVrTotalProd(p.getVrTotalProd());
    item.setOrigem(p.getOrigem());
    item.setBcIcmsProd(p.getBcIcmsProd());
    item.setAliqIcms(p.getAliqIcms());
    item.setVrDoIcms(p.getVrDoIcms());
    item.setStPisCofins(p.getStPisCofins());
    item.setBcPisCofins(p.getBcPisCofins());
    item.setRegimeApuPisCofins(p.getRegimeApuPisCofins());
    item.setVrPis(p.getVrPis());
    item.setVrCofins(p.getVrCofins());
    item.setStIPI(p.getStIPI());
    item.setCodIPI(p.getCodIPI());
    item.setAliqIPI(p.getAliqIPI());
    item.setVrIPI(p.getVrIPI());
    item.setVrTotalServ(p.getVrTotalServ());
    item.setBcISSQN(p.getBcISSQN());
    item.setVrISSQN(p.getVrISSQN());
    item.setRetIRRF(p.getRetIRRF());
    item.setRetPisCofins(p.getRetPisCofins());
    return item;

}).collect(Collectors.toList());

          // Relacionar nota com itens
          /* 
            ou seja: vincula o lado "many" ao lado "one" (cada item aponta para a nota). 
            Isso é importante para manter a integridade do relacionamento bidirecional.
          */
            itens.forEach(i -> i.setNotaFiscal(nota));
            nota.setItens(itens);


            // Salvar nota fiscal no banco
            notaFiscalRepository.save(nota);

            System.out.println("📦 Nota fiscal salva com sucesso no banco.");
            // 📃 Log para depuração (opcional)
            
            String jsonDebug = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            System.out.println("NF-e salva:");
            System.out.println(jsonDebug);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar nota fiscal: " + e.getMessage());
        
    }
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
}

