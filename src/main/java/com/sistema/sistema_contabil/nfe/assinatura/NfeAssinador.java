package com.sistema.sistema_contabil.nfe.assinatura;

import br.com.swconsultoria.nfe.Assinar;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AssinaturaEnum;
import org.springframework.stereotype.Component;

@Component
public class NfeAssinador {

    /**
     * Assina o XML conforme padrão da Java_NFe.
     * Observação: para NF-e “normal”, a assinatura é na tag infNFe.
     */
    public String assinarXml(ConfiguracoesNfe config, String xml) throws Exception {
        return Assinar.assinaNfe(config, xml, AssinaturaEnum.NFE);
    }
}

