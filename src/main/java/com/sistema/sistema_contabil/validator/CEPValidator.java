package com.sistema.sistema_contabil.validator;

import com.sistema.sistema_contabil.annotation.CEP;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;
import java.util.regex.Pattern;

@Slf4j
public class CEPValidator implements ConstraintValidator<CEP, String> {

    // Padrões de CEP por região
    private static final Map<String, Pattern> PADROES_ESTADOS = Map.of(
            "SP", Pattern.compile("^(0[1-9]|[1-9]\\d)\\d{3}-?\\d{3}$"), // 01000-000 a 99999-999
            "RJ", Pattern.compile("^(2[0-8])\\d{3}-?\\d{3}$"),           // 20000-000 a 28999-999
            "MG", Pattern.compile("^(3[0-9])\\d{3}-?\\d{3}$"),           // 30000-000 a 39999-999
            "DF", Pattern.compile("^(7[0-3])\\d{3}-?\\d{3}$"),           // 70000-000 a 73999-999
            "RS", Pattern.compile("^(9[0-9])\\d{3}-?\\d{3}$"),           // 90000-000 a 99999-999
            "PR", Pattern.compile("^(8[0-7])\\d{3}-?\\d{3}$"),           // 80000-000 a 87999-999
            "SC", Pattern.compile("^(8[8-9])\\d{3}-?\\d{3}$"),           // 88000-000 a 89999-999
            "BA", Pattern.compile("^(4[0-8])\\d{3}-?\\d{3}$"),           // 40000-000 a 48999-999
            "GO", Pattern.compile("^(7[2-6])\\d{3}-?\\d{3}$"),           // 72000-000 a 76999-999
            "PE", Pattern.compile("^(5[0-6])\\d{3}-?\\d{3}$")            // 50000-000 a 56999-999
    );

    // CEPs especiais conhecidos
    private static final Pattern CEP_ESPECIAL = Pattern.compile(
            "^(01310-100|04038-001|70040-010|20040-020)$" // Exemplos: Av. Paulista, Congresso, etc.
    );

    private static final Pattern CEP_FORMATO_BASICO = Pattern.compile("^\\d{5}-?\\d{3}$");
    private static final Pattern CEP_COM_HIFEN = Pattern.compile("^\\d{5}-\\d{3}$");
    private static final Pattern CEP_SEM_HIFEN = Pattern.compile("^\\d{8}$");

    private String estado;
    private boolean permitirZeros;
    private boolean permitirEspeciais;
    private boolean exigirHifen;

    @Override
    public void initialize(CEP constraintAnnotation) {
        this.estado = constraintAnnotation.estado().toUpperCase();
        this.permitirZeros = constraintAnnotation.permitirZeros();
        this.permitirEspeciais = constraintAnnotation.permitirEspeciais();
        this.exigirHifen = constraintAnnotation.exigirHifen();
    }

    @Override
    public boolean isValid(String cep, ConstraintValidatorContext context) {
        if (cep == null || cep.isBlank()) {
            return true; // Permite campos opcionais
        }

        // Remove espaços
        cep = cep.trim();

        // Validação do formato básico
        if (!CEP_FORMATO_BASICO.matcher(cep).matches()) {
            log.debug("CEP com formato inválido: {}", cep);
            return false;
        }

        // Verifica exigência de hífen
        if (exigirHifen && !CEP_COM_HIFEN.matcher(cep).matches()) {
            log.debug("CEP sem hífen obrigatório: {}", cep);
            return false;
        }

        // Normaliza o CEP (remove hífen para validações)
        String cepNumerico = cep.replaceAll("-", "");

        // Validações básicas
        if (!validacoesBasicas(cepNumerico)) {
            return false;
        }

        // Validação por estado específico
        if (!estado.isEmpty() && !validarPorEstado(cep)) {
            log.debug("CEP não pertence ao estado {}: {}", estado, cep);
            return false;
        }

        // Validação de CEPs especiais
        if (permitirEspeciais && isCEPEspecial(cep)) {
            return true;
        }

        return true;
    }

    private boolean validacoesBasicas(String cep) {
        // Não permite todos os dígitos iguais (exceto se permitir zeros)
        if (cep.matches("(\\d)\\1{7}")) {
            if (!permitirZeros || !cep.equals("00000000")) {
                log.debug("CEP com todos os dígitos iguais: {}", cep);
                return false;
            }
        }

        // Não permite CEPs obviamente inválidos
        if (cep.equals("12345678") || cep.equals("11111111")) {
            log.debug("CEP inválido conhecido: {}", cep);
            return false;
        }

        // CEP não pode começar com 00 (exceto se permitir zeros)
        if (cep.startsWith("00") && !permitirZeros) {
            log.debug("CEP iniciado com 00: {}", cep);
            return false;
        }

        return true;
    }

    private boolean validarPorEstado(String cep) {
        Pattern padrao = PADROES_ESTADOS.get(estado);
        if (padrao == null) {
            log.debug("Estado não mapeado para validação: {}", estado);
            return true; // Se o estado não está mapeado, aceita
        }

        return padrao.matcher(cep).matches();
    }

    private boolean isCEPEspecial(String cep) {
        // Remove hífen para comparação
        String cepLimpo = cep.replaceAll("-", "");
        String cepComHifen = cepLimpo.substring(0, 5) + "-" + cepLimpo.substring(5);

        return CEP_ESPECIAL.matcher(cepComHifen).matches();
    }
}
