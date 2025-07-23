package com.sistema.sistema_contabil.annotation;

import com.sistema.sistema_contabil.validator.InscricaoMunicipalValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InscricaoMunicipalValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface InscricaoMunicipal {

    String message() default "Inscrição Municipal inválida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Permite especificar o município para validação específica (opcional)
     */
    String municipio() default "";

    /**
     * Permite valores como "ISENTO", "DISPENSADO", etc.
     */
    boolean permitirIsento() default true;
}
