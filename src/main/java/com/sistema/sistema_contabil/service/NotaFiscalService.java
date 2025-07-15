package com.sistema.sistema_contabil.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.sistema_contabil.dto.NotaFiscalDTO;
import com.sistema.sistema_contabil.model.GeraisNfe;
import com.sistema.sistema_contabil.model.ItemNotaFiscal;
import com.sistema.sistema_contabil.model.NotaFiscal;
import com.sistema.sistema_contabil.model.Pagamento;
import com.sistema.sistema_contabil.model.PessoaJuridica;
import com.sistema.sistema_contabil.model.Transporte;
import com.sistema.sistema_contabil.repository.NotaFiscalRepository;
import com.sistema.sistema_contabil.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class NotaFiscalService {

    @Autowired 
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired 
    private PessoaRepository pessoaRepository;

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
    

    
    PessoaJuridica emitente = pessoaRepository.findByCnpj(dto.emitente.cnpj)
    .orElseThrow(() -> new RuntimeException("Emitente não encontrado com CNPJ: " + dto.emitente.cnpj));

    PessoaJuridica destinatario = pessoaRepository.findByCnpj(dto.destinatario.cnpj)
    .orElseThrow(() -> new RuntimeException("Destinatário não encontrado com CNPJ: " + dto.destinatario.cnpj));


        // Montar lista de itens
        List<ItemNotaFiscal> itens = dto.produtos.stream().map(p -> {
            ItemNotaFiscal item = new ItemNotaFiscal();
            item.setCodigo(p.codigo);
            item.setDescricao(p.descricao);
            item.setNcm(p.ncm);
            item.setCfop(p.cfop);
            item.setUnidade(p.unidade);
            item.setQuantidade(p.quantidade);
            item.setValorUnitario(p.valorUnitario);
            item.setDesconto(p.desconto);
            //item.setAliquotaIcms(p.aliquotaIcms);
            return item;
        }).collect(Collectors.toList());

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
        nota.setEmitente(emitente);
        nota.setDestinatario(destinatario);
        nota.setPagamento(pagamento);
        nota.setTransportadora(transporte);
        //nota.setXml("Será gerado no backend depois");

        // Relacionar nota com itens
        itens.forEach(i -> i.setNotaFiscal(nota));
        nota.setItens(itens);

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


        // Salvar nota fiscal no banco
        notaFiscalRepository.save(nota);

        System.out.println("📦 Nota fiscal salva com sucesso no banco.");
         // 📃 Log para depuração (opcional)
            ObjectMapper mapper = new ObjectMapper();
            String jsonDebug = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            System.out.println("NF-e salva:");
            System.out.println(jsonDebug);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar nota fiscal: " + e.getMessage());
        
    }
    }
}
