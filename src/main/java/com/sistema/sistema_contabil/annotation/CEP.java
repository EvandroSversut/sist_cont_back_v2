package com.sistema.sistema_contabil.annotation;

import com.sistema.sistema_contabil.validator.CEPValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CEPValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CEP {

    String message() default "CEP inválido. Use formato: 12345-678 ou 12345678";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Valida CEPs específicos de um estado (opcional)
     * Ex: "SP", "RJ", "MG"
     */
    String estado() default "";

    /**
     * Permite formatos alternativos como "00000-000"
     */
    boolean permitirZeros() default false;

    /**
     * Valida CEPs especiais (empresas, caixas postais, etc.)
     */
    boolean permitirEspeciais() default true;

    /**
     * Requer hífen obrigatório no formato
     */
    boolean exigirHifen() default false;
}
