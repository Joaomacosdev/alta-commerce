package br.com.altacommerce.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record FormaPagamentoRequestDTO(

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotNull(message = "O id da empresa é obrigatório")
        @Positive(message = "O id da empresa deve ser um valor positivo")
        Long empresaId
) {
}
