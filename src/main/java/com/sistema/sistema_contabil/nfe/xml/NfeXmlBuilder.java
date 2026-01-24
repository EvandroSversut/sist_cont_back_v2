package com.sistema.sistema_contabil.nfe.xml;

import br.com.swconsultoria.nfe.schema_4.enviNFe.TEnviNFe;
import br.com.swconsultoria.nfe.schema_4.nfe.TNFe;
import br.com.swconsultoria.nfe.schema_4.nfe.TNFe.InfNFe;
import org.springframework.stereotype.Component;

@Component
public class NfeXmlBuilder {

    public String gerarXmlNFe(GeraisDTO gerais, EmitenteDTO emit, DestinatarioDTO dest,
                              List<ItemDTO> itens, PagamentoDTO pag) throws Exception {

        TEnviNFe envi = new TEnviNFe();
        envi.setVersao("4.00");
        envi.setIdLote("1");

        TNFe nfe = new TNFe();
        InfNFe inf = new InfNFe();
        inf.setVersao("4.00");
        inf.setId("NFe" + gerais.getChaveAcesso());

        inf.setIde(BuilderIde.build(gerais));
        inf.setEmit(BuilderEmit.build(emit));
        inf.setDest(BuilderDest.build(dest));

        for (ItemDTO item : itens) {
            inf.getDet().add(BuilderDet.build(item));
        }

        inf.setTotal(BuilderTotal.build(itens));
        inf.setPag(BuilderPag.build(pag));

        nfe.setInfNFe(inf);
        envi.getNFe().add(nfe);

        return br.com.swconsultoria.nfe.util.NfeUtil.objectToXml(envi);
    }
}
