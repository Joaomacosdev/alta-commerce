package br.com.altacommerce.dto.melhor_envio.request;

public record OptionsRequestDTO(
        Boolean receipt,
        Boolean own_hand
) {
}
