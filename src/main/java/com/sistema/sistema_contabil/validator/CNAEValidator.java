package com.sistema.sistema_contabil.validator;

import com.sistema.sistema_contabil.annotation.CNAE;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CNAEValidator implements ConstraintValidator<CNAE, String> {

    private static final Pattern CNAE_PATTERN = Pattern.compile("^\\d{4}-\\d{1}/\\d{2}$|^\\d{7}$");

    @Override
    public void initialize(CNAE constraintAnnotation) {
        // Inicialização se necessário
    }

    @Override
    public boolean isValid(String cnae, ConstraintValidatorContext context) {
        if (cnae == null || cnae.isBlank()) {
            return true; // Permite campos opcionais
        }

        return CNAE_PATTERN.matcher(cnae).matches();
    }
}
