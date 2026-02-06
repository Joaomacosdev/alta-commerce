package br.com.altacommerce.integration.melhor_envio.calculate.request;

public record OptionsRequestDTO(
        Boolean receipt,
        Boolean own_hand
) {
}
