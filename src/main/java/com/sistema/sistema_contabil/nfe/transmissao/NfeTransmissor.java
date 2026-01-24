package com.sistema.sistema_contabil.nfe.transmissao;

import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.enuns.ConstantesUtil;
import br.com.swconsultoria.nfe.schema_4.retEnviNFe.RetEnviNFe;
import org.springframework.stereotype.Component;

@Component
public class NfeTransmissor {

    public RetEnviNFe transmitir(String xmlAssinado) throws Exception {
        return Nfe.enviarNfe(xmlAssinado, ConstantesUtil.NFE);
    }
}

