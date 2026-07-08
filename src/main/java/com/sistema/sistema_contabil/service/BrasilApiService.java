package com.sistema.sistema_contabil.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sistema.sistema_contabil.dto.BrasilApiDTO;

@Service
public class BrasilApiService {

    public BrasilApiDTO consultarCnpj(String cnpj) {

        try {
            String url = "https://brasilapi.com.br/api/cnpj/v1/" + cnpj;

            System.out.println("🌐 Chamando BrasilAPI: " + url);

            RestTemplate restTemplate = new RestTemplate();

            String resposta = restTemplate.getForObject(url, String.class);

            System.out.println("📦 RETORNO COMPLETO DA BRASILAPI:");

            System.out.println(resposta);
ObjectMapper mapper = new ObjectMapper();
mapper.enable(SerializationFeature.INDENT_OUTPUT);

String jsonBonito = mapper.readTree(resposta).toPrettyString();

System.out.println("📦 RETORNO FORMATADO:");
System.out.println(jsonBonito);

            return restTemplate.getForObject(url, BrasilApiDTO.class);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar CNPJ na BrasilAPI");
        }
    }
}