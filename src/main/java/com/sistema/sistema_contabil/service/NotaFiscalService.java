package com.sistema.sistema_contabil.service;

import com.sistema.sistema_contabil.dto.*;
import com.sistema.sistema_contabil.model.*;
import com.sistema.sistema_contabil.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NotaFiscalService {

    @Autowired private NotaFiscalRepository notaFiscalRepository;
    @Autowired private PessoaRepository pessoaRepository;

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
    } catch (Exception e) {
        System.err.println("❌ Erro ao converter DTO para JSON: " + e.getMessage());
    }

        
        // Buscar ou criar destinatário
        PessoaJuridica destinatario = pessoaRepository.findByCnpj(dto.destinatario.cnpj)
                .orElseGet(() -> {
                    PessoaJuridica nova = new PessoaJuridica();
                    nova.setTipo("DESTINATARIO");
                    nova.setCnpj(dto.destinatario.cnpj);
                    nova.setRazaoSocial(dto.destinatario.razaoSocial);
                    nova.setIe(dto.destinatario.ie);
                    nova.setUf(dto.destinatario.uf);
                    
                     nova.setCep("78787"); // ✅ CORRETO
                      nova.setCidade(""); // ✅ CORRETO
                    return pessoaRepository.save(nova);
                });

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
    }
}
