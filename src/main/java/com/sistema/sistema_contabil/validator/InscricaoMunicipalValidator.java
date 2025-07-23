package com.sistema.sistema_contabil.validator;

import com.sistema.sistema_contabil.annotation.InscricaoMunicipal;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InscricaoMunicipalValidator implements ConstraintValidator<InscricaoMunicipal, String> {

    private String municipio;
    private boolean permitirIsento;

    @Override
    public void initialize(InscricaoMunicipal constraintAnnotation) {
        this.municipio = constraintAnnotation.municipio();
        this.permitirIsento = constraintAnnotation.permitirIsento();
    }

    @Override
    public boolean isValid(String inscricaoMunicipal, ConstraintValidatorContext context) {
        if (inscricaoMunicipal == null || inscricaoMunicipal.isBlank()) {
            return true; // Permite campos opcionais
        }

        // Normaliza o texto
        String inscricaoLimpa = inscricaoMunicipal.trim().toUpperCase();

        // Verifica valores especiais
        if (permitirIsento && isValorEspecial(inscricaoLimpa)) {
            return true;
        }

        // Remove caracteres especiais para validação numérica
        String apenasNumeros = inscricaoLimpa.replaceAll("[^\\d]", "");

        // Validação básica: entre 5 e 15 dígitos
        if (apenasNumeros.length() < 5 || apenasNumeros.length() > 15) {
            return false;
        }

        // Não permite todos os dígitos iguais
        if (apenasNumeros.matches("(\\d)\\1+")) {
            return false;
        }

        // Validação específica por município (se especificado)
        if (!municipio.isEmpty()) {
            return validarPorMunicipio(apenasNumeros, municipio);
        }

        return true;
    }

    private boolean isValorEspecial(String valor) {
        return valor.equals("ISENTO") ||
                valor.equals("DISPENSADO") ||
                valor.equals("INEXISTENTE") ||
                valor.equals("N/A") ||
                valor.equals("SEM INSCRICAO") ||
                valor.equals("NAO SE APLICA");
    }

    private boolean validarPorMunicipio(String inscricao, String municipio) {
        log.debug("Validando inscrição municipal {} para município {}", inscricao, municipio);

        // Aqui você pode implementar validações específicas por município
        // Por exemplo:
        switch (municipio.toUpperCase()) {
            case "SAO PAULO":
                return validarSaoPaulo(inscricao);
            case "RIO DE JANEIRO":
                return validarRioDeJaneiro(inscricao);
            default:
                return true; // Validação genérica
        }
    }

    private boolean validarSaoPaulo(String inscricao) {
        // São Paulo: formato específico com 8-11 dígitos
        return inscricao.length() >= 8 && inscricao.length() <= 11;
    }

    private boolean validarRioDeJaneiro(String inscricao) {
        // Rio de Janeiro: formato específico com 7-8 dígitos
        return inscricao.length() >= 7 && inscricao.length() <= 8;
    }
}
