package com.sistema.sistema_contabil.nfe.assinatura;

import br.com.swconsultoria.nfe.assinatura.AssinaturaDigital;
import org.springframework.stereotype.Component;

@Component
public class NfeAssinador {

    public String assinarXml(String xml) throws Exception {
        return AssinaturaDigital.assinaDocumento(xml);
    }
}
