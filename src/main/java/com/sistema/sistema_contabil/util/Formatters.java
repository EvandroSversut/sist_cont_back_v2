package com.sistema.sistema_contabil.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class Formatters {

    /**
     * Formata CEP adicionando hífen se necessário
     *
     * @param cep CEP a ser formatado
     * @return CEP formatado (12345-678) ou null se inválido
     */
    public static String formatarCEP(String cep) {
        if (cep == null || cep.isBlank()) {
            return null;
        }

        // Remove caracteres não numéricos
        String apenasNumeros = cep.replaceAll("[^\\d]", "");

        // Verifica se tem 8 dígitos
        if (apenasNumeros.length() != 8) {
            log.debug("CEP deve ter 8 dígitos: {}", cep);
            return null;
        }

        // Formata com hífen
        return apenasNumeros.substring(0, 5) + "-" + apenasNumeros.substring(5);
    }

    /**
     * Remove formatação do CEP (retorna apenas números)
     *
     * @param cep CEP formatado
     * @return CEP sem formatação (12345678) ou null se inválido
     */
    public static String limparCEP(String cep) {
        if (cep == null || cep.isBlank()) {
            return null;
        }

        String apenasNumeros = cep.replaceAll("[^\\d]", "");

        return apenasNumeros.length() == 8 ? apenasNumeros : null;
    }

    /**
     * Verifica se o CEP tem formato válido (com ou sem hífen)
     *
     * @param cep CEP a ser verificado
     * @return true se o formato é válido
     */
    public static boolean isFormatoValido(String cep) {
        if (cep == null || cep.isBlank()) {
            return false;
        }

        return cep.matches("^\\d{5}-?\\d{3}$");
    }

    /**
     * Obtém o estado provável baseado no CEP
     *
     * @param cep CEP a ser analisado
     * @return Sigla do estado ou "DESCONHECIDO"
     */
    public static String obterEstadoPorCEP(String cep) {
        if (cep == null || cep.isBlank()) {
            return "DESCONHECIDO";
        }

        String cepLimpo = limparCEP(cep);
        if (cepLimpo == null) {
            return "DESCONHECIDO";
        }

        // Primeiro dígito indica a região
        char primeiroDigito = cepLimpo.charAt(0);

        return switch (primeiroDigito) {
            case '0' -> "SP"; // Grande São Paulo
            case '1' -> "SP"; // Interior de São Paulo
            case '2' -> "RJ"; // Rio de Janeiro e Espírito Santo
            case '3' -> "MG"; // Minas Gerais
            case '4' -> "BA"; // Bahia e Sergipe
            case '5' -> "PE"; // Pernambuco, Alagoas, Paraíba, RN
            case '6' -> "CE"; // Ceará, Piauí, Maranhão
            case '7' -> "DF"; // Distrito Federal, Goiás, Tocantins, MT, MS, RO, AC
            case '8' -> "PR"; // Paraná e Santa Catarina
            case '9' -> "RS"; // Rio Grande do Sul, Pará, AP, AM, RR
            default -> "DESCONHECIDO";
        };
    }

}
