package com.sistema.sistema_contabil.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.sistema_contabil.controller.AcessoController;
import com.sistema.sistema_contabil.dto.NotaFiscalDTO;
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

        // Criar nota fiscal
        NotaFiscal nota = new NotaFiscal();
        /* Explicaçao: exemplo Emitente: como na entity NotaFiscal está anotado como ManyToOne
         * o objeto PessoaJuridica passado no setEmitente() já tem um id preenchido
         * e o JPA entende que se o objeto tem ID, ele já existe no banco, entao nao deve
         * ser recriado, so referenciado
         * ✔️ Ou seja, ele não copia os dados do emitente e destinatário para a nota, 
         * apenas vincula os IDs já existentes
          */
        nota.setEmitente(emitente);
        nota.setDestinatario(destinatario);
        nota.setTransportadora(transporte);
        nota.setPagamento(pagamento);
        
      
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

        nota.setGeraisNfe(gerais);

                // Montar lista de itens
        // 📆 Converte a lista de ProdutoDTO em lista de ItemNotaFiscal vinculando com a nota.
        List<ItemNotaFiscal> itens = dto.produtos.stream().map(p -> {
            ItemNotaFiscal item = new ItemNotaFiscal();
            item.setCodigo(p.getCodigo());
            item.setDescricao(p.getDescricao());
            item.setNcm(p.getNcm());
            item.setUnidade(p.getUnidade());
            item.setCfop(p.getCfop());
            item.setQuantidade(p.getQuantidade());
            item.setValorUnitario(p.getValorUnitario());
            item.setDesconto(p.getDesconto());
            item.setFrete(p.getFrete());
            item.setSeguro(p.getSeguro());
            item.setOutraDesp(p.getOutraDesp());
            item.setValorTotal(p.getValorTotal());
            item.setIcms(p.getIcms());
            item.setIpi(p.getIpi());
            item.setPis(p.getPis());
            item.setCofins(p.getCofins());
            item.setIss(p.getIss());
            //item.setAliquotaIcms(p.aliquotaIcms);
            return item;
        }).collect(Collectors.toList());

          // Relacionar nota com itens
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
}
