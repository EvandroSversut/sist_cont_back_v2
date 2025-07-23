package com.sistema.sistema_contabil.validator;

import com.sistema.sistema_contabil.annotation.CEP;
import com.sistema.sistema_contabil.annotation.InscricaoMunicipal;
import com.sistema.sistema_contabil.annotation.Telefone;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

/**
 * <h1>Exemplos de Uso das Anotações de Validação Customizadas</h1>
 *
 * <p>Esta classe demonstra como utilizar as anotações de validação customizadas
 * desenvolvidas para o sistema contábil. Todas as anotações são baseadas no
 * Jakarta Bean Validation e funcionam automaticamente com Spring Boot.</p>
 *
 * <h2>Anotações Disponíveis:</h2>
 * <ul>
 *   <li>{@link CEP} - Validação de CEP brasileiro</li>
 *   <li>{@link Telefone} - Validação de telefone brasileiro e internacional</li>
 *   <li>{@link InscricaoMunicipal} - Validação de inscrição municipal</li>
 *   <li>{@link CPF} - Validação de CPF brasileiro</li>
 *   <li>{@link CNPJ} - Validação de CNPJ brasileiro</li>
 * </ul>
 *
 * <h2>Como Usar:</h2>
 * <p>Simplesmente adicione a anotação desejada no campo do seu DTO, Entity ou
 * parâmetro de método. O Spring Boot validará automaticamente quando:</p>
 * <ul>
 *   <li>Receber requisições HTTP com {@code @Valid}</li>
 *   <li>Persistir entidades JPA</li>
 *   <li>Executar validações manuais</li>
 * </ul>
 *
 * @author Sistema Contábil Team
 * @version 1.0
 * @since Java 17
 *
 * @see jakarta.validation.constraints
 * @see org.springframework.validation.annotation.Validated
 */
public class ValidacaoCustomizadaExemplos {

    // ==========================================
    // EXEMPLOS DE VALIDAÇÃO DE CEP
    // ==========================================

    /**
     * <h3>CEP Básico</h3>
     * <p>Aceita qualquer formato válido de CEP brasileiro.</p>
     *
     * <h4>Formatos Aceitos:</h4>
     * <ul>
     *   <li>12345-678</li>
     *   <li>12345678</li>
     * </ul>
     *
     * <h4>Validações Aplicadas:</h4>
     * <ul>
     *   <li>8 dígitos obrigatórios</li>
     *   <li>Formato brasileiro válido</li>
     *   <li>Não permite todos os dígitos iguais</li>
     * </ul>
     *
     * @example "01310-100", "12345678"
     */
    @CEP
    private String cep;

    /**
     * <h3>CEP Específico de São Paulo</h3>
     * <p>Valida apenas CEPs pertencentes ao estado de São Paulo.</p>
     *
     * <h4>Faixa Válida:</h4>
     * <ul>
     *   <li>01000-000 a 19999-999 (Grande São Paulo)</li>
     *   <li>11000-000 a 19999-999 (Interior)</li>
     * </ul>
     *
     * @example "01310-100" (Av. Paulista), "13001-000" (Campinas)
     */
    @CEP(estado = "SP")
    private String cepSaoPaulo;

    /**
     * <h3>CEP com Hífen Obrigatório</h3>
     * <p>Exige que o CEP seja informado obrigatoriamente com hífen.</p>
     *
     * <h4>Formato Exigido:</h4>
     * <p>12345-678 (hífen obrigatório)</p>
     *
     * @example "01310-100" ✅, "01310100" ❌
     */
    @CEP(exigirHifen = true)
    private String cepComHifen;

    /**
     * <h3>CEP que Não Permite Zeros</h3>
     * <p>Rejeita CEPs como "00000-000" que podem ser usados como placeholder.</p>
     *
     * <h4>CEPs Rejeitados:</h4>
     * <ul>
     *   <li>00000-000</li>
     *   <li>00000000</li>
     * </ul>
     *
     * @example "12345-678" ✅, "00000-000" ❌
     */
    @CEP(permitirZeros = false)
    private String cepSemZeros;

    /**
     * <h3>CEP Restritivo</h3>
     * <p>Configuração mais restritiva possível:</p>
     * <ul>
     *   <li>Não permite CEPs especiais</li>
     *   <li>Não permite zeros</li>
     *   <li>Exige hífen obrigatório</li>
     * </ul>
     *
     * <h4>Uso Recomendado:</h4>
     * <p>Campos críticos onde a precisão é essencial.</p>
     *
     * @example "12345-678" ✅, "00000-000" ❌, "12345678" ❌
     */
    @CEP(permitirEspeciais = false, permitirZeros = false, exigirHifen = true)
    private String cepRestritivo;

    /**
     * <h3>CEP Flexível</h3>
     * <p>Configuração mais permissiva possível:</p>
     * <ul>
     *   <li>Permite CEPs especiais</li>
     *   <li>Permite zeros</li>
     *   <li>Não exige hífen</li>
     * </ul>
     *
     * <h4>Uso Recomendado:</h4>
     * <p>Importação de dados ou campos opcionais.</p>
     *
     * @example "12345-678", "12345678", "00000-000", "01310-100"
     */
    @CEP(permitirEspeciais = true, permitirZeros = true, exigirHifen = false)
    private String cepFlexivel;

    // ==========================================
    // EXEMPLOS DE VALIDAÇÃO DE TELEFONE
    // ==========================================

    /**
     * <h3>Telefone Apenas Celular</h3>
     * <p>Aceita apenas números de celular (9 dígitos após o DDD).</p>
     *
     * <h4>Formatos Aceitos:</h4>
     * <ul>
     *   <li>(11) 99999-9999</li>
     *   <li>11999999999</li>
     *   <li>11 99999-9999</li>
     * </ul>
     *
     * <h4>Validações Aplicadas:</h4>
     * <ul>
     *   <li>DDD válido brasileiro</li>
     *   <li>Deve começar com 9</li>
     *   <li>9 dígitos após o DDD</li>
     * </ul>
     *
     * @example "(11) 99999-9999", "21987654321"
     */
    @Telefone(permitirFixo = false, permitirCelular = true)
    private String celular;

    /**
     * <h3>Telefone Apenas Fixo</h3>
     * <p>Aceita apenas números de telefone fixo (8 dígitos após o DDD).</p>
     *
     * <h4>Formatos Aceitos:</h4>
     * <ul>
     *   <li>(11) 3333-4444</li>
     *   <li>1133334444</li>
     *   <li>11 3333-4444</li>
     * </ul>
     *
     * <h4>Validações Aplicadas:</h4>
     * <ul>
     *   <li>DDD válido brasileiro</li>
     *   <li>Não pode começar com 0 ou 1</li>
     *   <li>8 dígitos após o DDD</li>
     * </ul>
     *
     * @example "(11) 3333-4444", "2133334444"
     */
    @Telefone(permitirFixo = true, permitirCelular = false)
    private String telefoneFixo;

    /**
     * <h3>Telefone Internacional</h3>
     * <p>Aceita números de telefone internacionais com código do país.</p>
     *
     * <h4>Formatos Aceitos:</h4>
     * <ul>
     *   <li>+55 11 99999-9999 (Brasil)</li>
     *   <li>+1 555 123 4567 (EUA)</li>
     *   <li>+44 20 7946 0958 (Reino Unido)</li>
     * </ul>
     *
     * <h4>Validações Aplicadas:</h4>
     * <ul>
     *   <li>Deve começar com +</li>
     *   <li>Código do país válido</li>
     *   <li>Formato internacional padrão</li>
     * </ul>
     *
     * @example "+5511999999999", "+12125551234"
     */
    @Telefone(permitirInternacional = true)
    private String telefoneInternacional;

    /**
     * <h3>Telefone Completo</h3>
     * <p>Aceita tanto celular quanto fixo, nacional e internacional.</p>
     *
     * <h4>Uso Recomendado:</h4>
     * <p>Campos de contato geral onde não se sabe o tipo específico.</p>
     *
     * @example "(11) 99999-9999", "(11) 3333-4444", "+5511999999999"
     */
    @Telefone(permitirFixo = true, permitirCelular = true, permitirInternacional = true)
    private String telefoneCompleto;

    // ==========================================
    // EXEMPLOS DE VALIDAÇÃO DE INSCRIÇÃO MUNICIPAL
    // ==========================================

    /**
     * <h3>Inscrição Municipal de São Paulo</h3>
     * <p>Validação específica para inscrições municipais de São Paulo.</p>
     *
     * <h4>Características:</h4>
     * <ul>
     *   <li>Formato específico de São Paulo</li>
     *   <li>Permite valores como "ISENTO"</li>
     *   <li>Validação de dígitos verificadores</li>
     * </ul>
     *
     * <h4>Valores Aceitos:</h4>
     * <ul>
     *   <li>Números com formato válido</li>
     *   <li>"ISENTO", "DISPENSADO"</li>
     * </ul>
     *
     * @example "12345678-01", "ISENTO"
     */
    @InscricaoMunicipal(municipio = "SAO PAULO", permitirIsento = true)
    private String inscMunicipalSP;

    /**
     * <h3>Inscrição Municipal Obrigatória</h3>
     * <p>Inscrição municipal obrigatória que não aceita valores como "ISENTO".</p>
     *
     * <h4>Características:</h4>
     * <ul>
     *   <li>Campo obrigatório</li>
     *   <li>Não permite "ISENTO" ou similares</li>
     *   <li>Deve ser um número válido</li>
     * </ul>
     *
     * <h4>Uso Recomendado:</h4>
     * <p>Empresas que obrigatoriamente devem ter inscrição municipal.</p>
     *
     * @example "12345678-01" ✅, "ISENTO" ❌, "" ❌
     */
    @NotBlank(message = "Inscrição municipal é obrigatória")
    @InscricaoMunicipal(permitirIsento = false)
    private String inscMunicipalObrigatoria;

    /**
     * <h3>Inscrição Municipal Genérica</h3>
     * <p>Validação genérica que funciona para qualquer município.</p>
     *
     * <h4>Características:</h4>
     * <ul>
     *   <li>Validação básica de formato</li>
     *   <li>Permite "ISENTO"</li>
     *   <li>Funciona para qualquer cidade</li>
     * </ul>
     *
     * @example "123456", "ISENTO", "12.345.678-01"
     */
    @InscricaoMunicipal(permitirIsento = true)
    private String inscMunicipalGenerica;

    // ==========================================
    // EXEMPLOS DE VALIDAÇÃO DE DOCUMENTOS
    // ==========================================

    /**
     * <h3>CPF com Validação Completa</h3>
     * <p>Validação completa de CPF brasileiro com dígitos verificadores.</p>
     *
     * <h4>Formatos Aceitos:</h4>
     * <ul>
     *   <li>123.456.789-10</li>
     *   <li>12345678910</li>
     * </ul>
     *
     * <h4>Validações Aplicadas:</h4>
     * <ul>
     *   <li>11 dígitos obrigatórios</li>
     *   <li>Cálculo dos dígitos verificadores</li>
     *   <li>Não permite CPFs inválidos conhecidos</li>
     * </ul>
     *
     * @example "123.456.789-10", "12345678910"
     */
    @CPF
    private String cpf;

    /**
     * <h3>CNPJ com Validação Completa</h3>
     * <p>Validação completa de CNPJ brasileiro com dígitos verificadores.</p>
     *
     * <h4>Formatos Aceitos:</h4>
     * <ul>
     *   <li>12.345.678/0001-90</li>
     *   <li>12345678000190</li>
     * </ul>
     *
     * <h4>Validações Aplicadas:</h4>
     * <ul>
     *   <li>14 dígitos obrigatórios</li>
     *   <li>Cálculo dos dígitos verificadores</li>
     *   <li>Não permite CNPJs inválidos conhecidos</li>
     * </ul>
     *
     * @example "12.345.678/0001-90", "12345678000190"
     */
    @CNPJ
    private String cnpj;

    // ==========================================
    // EXEMPLOS DE COMBINAÇÕES
    // ==========================================

    /**
     * <h3>Endereço Completo com Validações</h3>
     * <p>Exemplo de como combinar múltiplas validações em um endereço.</p>
     *
     * <h4>Validações Aplicadas:</h4>
     * <ul>
     *   <li>CEP específico de São Paulo</li>
     *   <li>Telefone que aceita fixo e celular</li>
     *   <li>Campos obrigatórios</li>
     * </ul>
     */
    public static class EnderecoCompleto {

        @NotBlank(message = "Rua é obrigatória")
        private String rua;

        @NotBlank(message = "Número é obrigatório")
        private String numero;

        private String complemento;

        @NotBlank(message = "Bairro é obrigatório")
        private String bairro;

        /**
         * CEP específico de São Paulo com hífen obrigatório
         */
        @CEP(estado = "SP", exigirHifen = true)
        private String cep;

        @NotBlank(message = "Cidade é obrigatória")
        private String cidade;

        @NotBlank(message = "UF é obrigatório")
        private String uf;

        /**
         * Telefone que aceita fixo e celular
         */
        @Telefone(permitirFixo = true, permitirCelular = true)
        private String telefone;
    }

    /**
     * <h3>Empresa com Validações Completas</h3>
     * <p>Exemplo de entidade empresa com todas as validações aplicadas.</p>
     */
    public static class EmpresaCompleta {

        @NotBlank(message = "Razão social é obrigatória")
        private String razaoSocial;

        /**
         * CNPJ com validação completa de dígitos verificadores
         */
        @CNPJ
        private String cnpj;

        /**
         * Inscrição municipal que permite ISENTO
         */
        @InscricaoMunicipal(permitirIsento = true)
        private String inscricaoMunicipal;

        /**
         * CEP flexível que aceita qualquer formato
         */
        @CEP(permitirEspeciais = true, permitirZeros = false)
        private String cep;

        /**
         * Telefone comercial (fixo e celular)
         */
        @Telefone(permitirFixo = true, permitirCelular = true)
        private String telefone;
    }
}


