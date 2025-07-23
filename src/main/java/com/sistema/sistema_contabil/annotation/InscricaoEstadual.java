package com.sistema.sistema_contabil.annotation;

import com.sistema.sistema_contabil.validator.InscricaoEstadualValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InscricaoEstadualValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface InscricaoEstadual {

    String message() default "Inscrição Estadual inválida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * UF para validação específica (opcional)
     */
    String uf() default "";
}
