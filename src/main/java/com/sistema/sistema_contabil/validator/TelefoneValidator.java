package com.sistema.sistema_contabil.validator;

import com.sistema.sistema_contabil.annotation.Telefone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import java.util.Set;
import java.util.regex.Pattern;

@Slf4j
public class TelefoneValidator implements ConstraintValidator<Telefone, String> {

    // DDDs válidos no Brasil
    private static final Set<String> DDDS_VALIDOS = Set.of(
            "11", "12", "13", "14", "15", "16", "17", "18", "19", // SP
            "21", "22", "24", // RJ/ES
            "27", "28", // ES
            "31", "32", "33", "34", "35", "37", "38", // MG
            "41", "42", "43", "44", "45", "46", // PR
            "47", "48", "49", // SC
            "51", "53", "54", "55", // RS
            "61", // DF
            "62", "64", // GO
            "63", // TO
            "65", "66", // MT
            "67", // MS
            "68", // AC
            "69", // RO
            "71", "73", "74", "75", "77", // BA
            "79", // SE
            "81", "87", // PE
            "82", // AL
            "83", // PB
            "84", // RN
            "85", "88", // CE
            "86", "89", // PI
            "91", "93", "94", // PA
            "92", "97", // AM
            "95", // RR
            "96", // AP
            "98", "99" // MA
    );

    private static final Pattern TELEFONE_INTERNACIONAL =
            Pattern.compile("^\\+[1-9]\\d{1,14}$");

    private boolean permitirFixo;
    private boolean permitirCelular;
    private boolean dddObrigatorio;
    private boolean permitirInternacional;

    @Override
    public void initialize(Telefone constraintAnnotation) {
        this.permitirFixo = constraintAnnotation.permitirFixo();
        this.permitirCelular = constraintAnnotation.permitirCelular();
        this.dddObrigatorio = constraintAnnotation.dddObrigatorio();
        this.permitirInternacional = constraintAnnotation.permitirInternacional();
    }

    @Override
    public boolean isValid(String telefone, ConstraintValidatorContext context) {
        if (telefone == null || telefone.isBlank()) {
            return true; // Permite campos opcionais
        }

        // Telefone internacional
        if (permitirInternacional && telefone.startsWith("+")) {
            return TELEFONE_INTERNACIONAL.matcher(telefone).matches();
        }

        // Remove caracteres especiais
        String apenasNumeros = telefone.replaceAll("[^\\d]", "");

        // Validação básica de comprimento
        if (apenasNumeros.length() < 10 || apenasNumeros.length() > 11) {
            return false;
        }

        // Extrai DDD e número
        String ddd = apenasNumeros.substring(0, 2);
        String numero = apenasNumeros.substring(2);

        // Valida DDD
        if (dddObrigatorio && !DDDS_VALIDOS.contains(ddd)) {
            log.debug("DDD inválido: {}", ddd);
            return false;
        }

        // Valida tipos de telefone
        boolean isValido = false;

        if (numero.length() == 8 && permitirFixo) {
            // Telefone fixo: não pode começar com 0 ou 1
            isValido = !numero.startsWith("0") && !numero.startsWith("1");
        }

        if (numero.length() == 9 && permitirCelular) {
            // Celular: deve começar com 9
            isValido = numero.startsWith("9");
        }

        // Não permite números com todos os dígitos iguais
        if (isValido && numero.matches("(\\d)\\1+")) {
            return false;
        }

        return isValido;
    }
}
