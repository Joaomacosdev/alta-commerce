package br.com.altacommerce.integration.melhor_envio.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductDTO(
        String name,
        String quantity,

        @JsonProperty("unitary_value")
        String unitaryValue
) {
}
