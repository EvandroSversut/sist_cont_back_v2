package com.sistema.sistema_contabil.dto;

import java.util.List;

public class NotaFiscalDTO {

    private GeraisDTO gerais;
    private PessoaJuridicaDTO emitente;
    private PessoaJuridicaDTO destinatario;
    private List<ProdutoDTO> produtos;
    private TransporteDTO transporte;
    private PagamentoDTO pagamento;

    public GeraisDTO getGerais() {
        return gerais;
    }
    public void setGerais(GeraisDTO gerais) {
        this.gerais = gerais;
    }
    
    public PessoaJuridicaDTO getEmitente() {
        return emitente;
    }
    public void setEmitente(PessoaJuridicaDTO emitente) {
        this.emitente = emitente;
    }
    public PessoaJuridicaDTO getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(PessoaJuridicaDTO destinatario) {
        this.destinatario = destinatario;
    }
    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }
    public TransporteDTO getTransporte() {
        return transporte;
    }
    public void setTransporte(TransporteDTO transporte) {
        this.transporte = transporte;
    }
    public PagamentoDTO getPagamento() {
        return pagamento;
    }
    public void setPagamento(PagamentoDTO pagamento) {
        this.pagamento = pagamento;
    }
    

    
    
}
