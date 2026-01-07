package br.com.altacommerce.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public record NotaFiscalCompraRequestDTO(
        @NotBlank(message = "A série da nota é obrigatória")
        String serieNota,

        String descricaoObs,

        @NotNull(message = "O valor total é obrigatório")
        @DecimalMin(value = "0.00", inclusive = false, message = "O valor total deve ser maior que zero")
        @Digits(integer = 15, fraction = 2, message = "Valor total inválido")
        BigDecimal valorTotal,

        @DecimalMin(value = "0.00", message = "O valor de desconto não pode ser negativo")
        @Digits(integer = 15, fraction = 2, message = "Valor de desconto inválido")
        BigDecimal valorDesconto,

        @NotNull(message = "O valor do ICMS é obrigatório")
        @DecimalMin(value = "0.00", message = "O valor do ICMS não pode ser negativo")
        @Digits(integer = 15, fraction = 2, message = "Valor de ICMS inválido")
        BigDecimal valorIcms,


        @NotNull(message = "A pessoa é obrigatória")
        Long pessoaId,

        @NotNull(message = "A conta a pagar é obrigatória")
        Long contaPagarId,

        @NotNull(message = "A empresa é obrigatória")
        Long empresaId,

        @NotNull(message = "A nota fiscal deve conter ao menos um item")
        @NotEmpty(message = "A lista de itens não pode estar vazia")
        @Valid
        List<NotaItemProdutoRequestDTO> itens


) {
}
