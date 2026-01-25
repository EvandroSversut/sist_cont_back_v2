package com.sistema.sistema_contabil.nfe.transmissao;

import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.DocumentoEnum;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TEnviNFe;
import br.com.swconsultoria.nfe.schema_4.enviNFe.TRetEnviNFe;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.StringReader;

@Component
public class NfeTransmissor {

    public TRetEnviNFe transmitir(ConfiguracoesNfe config, String xmlAssinado) throws Exception {
        TEnviNFe enviNFe = xmlToObj(xmlAssinado, TEnviNFe.class);
        return Nfe.enviarNfe(config, enviNFe, DocumentoEnum.NFE);
    }

    private <T> T xmlToObj(String xml, Class<T> clazz) throws Exception {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return clazz.cast(unmarshaller.unmarshal(new StringReader(xml)));
    }
}
