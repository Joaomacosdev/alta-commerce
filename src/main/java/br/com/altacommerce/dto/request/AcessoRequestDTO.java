package br.com.altacommerce.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record AcessoRequestDTO(
        @NotBlank(message = "Descrição não pode ser vazia")
        @Size(max = 15, message = "Descrição deve ter no máximo 255 caracteres")
        String descricao) {
}
