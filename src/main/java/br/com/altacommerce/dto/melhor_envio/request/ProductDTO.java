package br.com.altacommerce.dto.melhor_envio.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductDTO(
        String name,
        String quantity,

        @JsonProperty("unitary_value")
        String unitaryValue
) {
}
