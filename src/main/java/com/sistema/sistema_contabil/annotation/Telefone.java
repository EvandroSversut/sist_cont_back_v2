package com.sistema.sistema_contabil.annotation;

import com.sistema.sistema_contabil.validator.TelefoneValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelefoneValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Telefone {

    String message() default "Telefone inválido. Use formato: (11) 99999-9999, (11) 9999-9999 ou 11999999999";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Permite telefone fixo (8 dígitos após DDD)
     */
    boolean permitirFixo() default true;

    /**
     * Permite celular (9 dígitos após DDD)
     */
    boolean permitirCelular() default true;

    /**
     * Exige DDD obrigatório
     */
    boolean dddObrigatorio() default true;

    /**
     * Permite números internacionais
     */
    boolean permitirInternacional() default false;
}
