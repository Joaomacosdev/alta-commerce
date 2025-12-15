package br.com.altacommerce.dto.request;

import javax.validation.constraints.NotBlank;

public record AcessoDeleteRequestDTO(
        @NotBlank(message = "Id obrigatório")
        Long id) {
}
