package br.com.altacommerce.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record ItemVendaLojaRequestDTO(


        @NotNull(message = "A quantidade é obrigatória")
        @Positive(message = "A quantidade deve ser maior que zero")
        Double quantidade,
        @NotNull(message = "O produto é obrigatório")
        Long produtoId

//        @NotNull(message = "A empresa é obrigatória")
//        Long empresaId
) {
}
