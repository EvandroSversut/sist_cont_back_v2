package com.sistema.sistema_contabil.annotation;

import com.sistema.sistema_contabil.validator.CNAEValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CNAEValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CNAE {

    String message() default "CNAE inválido. Use formato: 0000-0/00 ou 0000000";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}