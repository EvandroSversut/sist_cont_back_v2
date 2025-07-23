package com.sistema.sistema_contabil.dto;

import java.util.List;

import lombok.Data;

@Data
public class NotaFiscalDTO {

    public GeraisDTO gerais;
    public EmitenteDTO emitente;
    public DestinatarioDTO destinatario;
    public List<ProdutoDTO> produtos;
    public TransporteDTO transporte;
    public PagamentoDTO pagamento;
    
}
