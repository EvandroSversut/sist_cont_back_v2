package com.sistema.sistema_contabil.dto;

import java.util.List;

public class NotaFiscalDTO {

    public GeraisDTO gerais;
    public EmitenteDTO emitente;
    public DestinatarioDTO destinatario;
    public List<ProdutoDTO> produtos;
    public TransporteDTO transporte;
    public PagamentoDTO pagamento;
    
    public EmitenteDTO getEmitente() {
        return emitente;
    }
    public void setEmitente(EmitenteDTO emitente) {
        this.emitente = emitente;
    }
    public DestinatarioDTO getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(DestinatarioDTO destinatario) {
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
    public GeraisDTO getGerais() {
        return gerais;
    }
    public void setGerais(GeraisDTO gerais) {
        this.gerais = gerais;
    }

    
    
}
