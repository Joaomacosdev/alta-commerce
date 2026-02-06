package br.com.altacommerce.integration.melhor_envio.cart.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponseDTO(
        String name,
        Integer quantity,

        @JsonProperty("unitary_value")
        Integer unitaryValue,

        String weight
) {
}
