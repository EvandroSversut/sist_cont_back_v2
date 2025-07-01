package com.sistema.sistema_contabil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.sistema_contabil.dto.NotaFiscalDTO;
import com.sistema.sistema_contabil.model.NotaFiscal;
import com.sistema.sistema_contabil.repository.NotaFiscalRepository;

@Service
public class NotaFiscalService {

    @Autowired
    private NotaFiscalRepository repository;

     public void salvarNotaFiscalEstruturada(NotaFiscalDTO dto) {
        // Aqui você transforma o DTO em entidades (model)
        NotaFiscal nota = new NotaFiscal();

        nota.setEmitenteCnpj(dto.emitente.cnpj);
        nota.setDestinatarioNome(dto.destinatario.razaoSocial);
        nota.setXml("Será gerado posteriormente");

        repository.save(nota);
     }

    public NotaFiscal salvar(String xml) {
        NotaFiscal nf = new NotaFiscal(xml);
        return repository.save(nf);
    }

     // Método de teste para salvar XML fixo
    public void testeSalvar() {
    String xmlTeste = "<nfeProc>Teste XML de exemplo</nfeProc>";
    NotaFiscal nf = new NotaFiscal(xmlTeste);
    repository.save(nf);
}

}
