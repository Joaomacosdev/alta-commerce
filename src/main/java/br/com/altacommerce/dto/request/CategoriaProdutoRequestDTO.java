package br.com.altacommerce.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record CategoriaProdutoRequestDTO(
        @NotBlank(message = "O nome/descrição é obrigatório")
        @Size(min = 3, max = 255, message = "O nome/descrição deve ter entre 3 e 255 caracteres")
        String nomeDesc,

        @NotNull(message = "A empresa é obrigatória")
        Long empresaId
) {
}
