package com.sistema.sistema_contabil.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.sistema_contabil.dto.NotaFiscalDTO;
import com.sistema.sistema_contabil.model.ItemNotaFiscal;
import com.sistema.sistema_contabil.model.NotaFiscal;
import com.sistema.sistema_contabil.model.Pagamento;
import com.sistema.sistema_contabil.model.Pessoa;
import com.sistema.sistema_contabil.model.PessoaJuridica;
import com.sistema.sistema_contabil.model.Transporte;
import com.sistema.sistema_contabil.repository.NotaFiscalRepository;
import com.sistema.sistema_contabil.repository.PessoaRepository;

@Service
public class NotaFiscalService {

    @Autowired private NotaFiscalRepository notaFiscalRepository;
    @Autowired private PessoaRepository pessoaRepository;

    public void salvarNotaFiscalEstruturada(NotaFiscalDTO dto) {
        System.out.println("✅ Service - Recebendo NF-e do front (DTO).");
        
            try {
        ObjectMapper mapper = new ObjectMapper();
        String jsonDTO = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
        System.out.println("🔍 Dados recebidos do front-end (DTO):\n" + jsonDTO);
    } catch (Exception e) {
        System.err.println("❌ Erro ao converter DTO para JSON: " + e.getMessage());
    }

        // Buscar ou criar destinatário
        Pessoa destinatario = pessoaRepository.findByCnpj(dto.destinatario.cnpj)
                .orElseGet(() -> {
                    PessoaJuridica nova = new PessoaJuridica();
                    nova.setTipo("DESTINATARIO");
                    nova.setCnpj(dto.destinatario.cnpj);
                    nova.setRazaoSocial(dto.destinatario.razaoSocial);
                    nova.setIe(dto.destinatario.ie);
                    nova.setUf(dto.destinatario.uf);
                    nova.setMunicipio(dto.destinatario.municipio);
                    nova.setComplemento(""); // ✅ CORRETO
                    nova.setEmail(""); // ✅ CORRETO
                    nova.setNumero(""); // ✅ CORRETO
                    nova.setRua(""); // ✅ CORRETO
                    nova.setTelefone(""); // ✅ CORRETO
                    nova.setUf(""); // ✅ CORRETO
                    nova.setCep(""); // ✅ CORRETO
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
            item.setAliquotaIcms(p.aliquotaIcms);
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
        transporte.setValorFrete(dto.transporte.valorFrete);

        // Criar nota fiscal
        NotaFiscal nota = new NotaFiscal();
        nota.setDestinatario(destinatario);
        nota.setPagamento(pagamento);
        nota.setTransportadora(transporte);
        nota.setXml("Será gerado no backend depois");

        // Relacionar nota com itens
        itens.forEach(i -> i.setNotaFiscal(nota));
        nota.setItens(itens);

        notaFiscalRepository.save(nota);

        System.out.println("📦 Nota fiscal salva com sucesso no banco.");
    }
}
