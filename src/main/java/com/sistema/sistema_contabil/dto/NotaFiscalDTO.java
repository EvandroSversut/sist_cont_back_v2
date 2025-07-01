package com.sistema.sistema_contabil.dto;

import java.util.List;

public class NotaFiscalDTO {

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

    // getters e setters omitidos por simplicidade
    
}
