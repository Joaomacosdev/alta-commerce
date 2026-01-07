package br.com.altacommerce.dto.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public record NotaItemProdutoRequestDTO(
        @NotNull(message = "O produto é obrigatório")
        Long produtoId,
        @NotNull(message = "A quantidade é obrigatória")
        @DecimalMin(value = "0.01", message = "A quantidade deve ser maior que zero")
        Double quantidade
) {
}
