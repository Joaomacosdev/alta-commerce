package br.com.altacommerce.dto.request;

import javax.validation.constraints.*;

public record AvaliacaoProdutoRequestDTO(
        @NotBlank(message = "A descrição é obrigatória")
        @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
        String descricao,

        @NotNull(message = "A nota é obrigatória")
        @Min(value = 1, message = "A nota mínima é 1")
        @Max(value = 5, message = "A nota máxima é 5")
        Integer nota,

        @NotNull(message = "O ID da pessoa é obrigatório")
        Long pessoaId,

        @NotNull(message = "O ID do produto é obrigatório")
        Long produtoId,

        @NotNull(message = "O ID da empresa é obrigatório")
        Long empresaId
) {
}
