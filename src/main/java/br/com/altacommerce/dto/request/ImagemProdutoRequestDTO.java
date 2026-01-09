package br.com.altacommerce.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record ImagemProdutoRequestDTO(
        @NotBlank(message = "A imagem é obrigatória")
        @Size(max = 5_000_000, message = "A imagem Base64 é muito grande")
        String imagemOriginal
) {
}
