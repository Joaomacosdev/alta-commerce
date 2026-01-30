package br.com.altacommerce.dto.melhor_envio.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponseDTO(
        String name,
        Integer quantity,

        @JsonProperty("unitary_value")
        Integer unitaryValue,

        String weight
) {
}
