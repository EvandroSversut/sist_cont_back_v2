package com.sistema.sistema_contabil.validator;

import com.sistema.sistema_contabil.annotation.InscricaoEstadual;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class InscricaoEstadualValidator implements ConstraintValidator<InscricaoEstadual, String> {

    private String uf;

    @Override
    public void initialize(InscricaoEstadual constraintAnnotation) {
        this.uf = constraintAnnotation.uf();
    }

    @Override
    public boolean isValid(String inscricaoEstadual, ConstraintValidatorContext context) {
        if (inscricaoEstadual == null || inscricaoEstadual.isBlank()) {
            return true; // Permite campos opcionais
        }

        // Remove caracteres especiais
        inscricaoEstadual = inscricaoEstadual.replaceAll("[^\\d]", "");

        // Verifica ISENTO
        if (inscricaoEstadual.equalsIgnoreCase("ISENTO")) {
            return true;
        }

        // Validação básica: entre 8 e 14 dígitos
        if (inscricaoEstadual.length() < 8 || inscricaoEstadual.length() > 14) {
            return false;
        }

        // Aqui você pode adicionar validações específicas por UF
        // Por simplicidade, fazemos uma validação básica
        return !inscricaoEstadual.matches("(\\d)\\1+"); // Não permite todos iguais
    }
}
