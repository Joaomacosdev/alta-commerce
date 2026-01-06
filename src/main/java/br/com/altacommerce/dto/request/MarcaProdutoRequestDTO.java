package br.com.altacommerce.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record MarcaProdutoRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
        String nomeDesc,
        @NotNull(message = "A empresa é obrigatória")
        Long empresaId
) {
}
