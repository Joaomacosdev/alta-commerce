package br.com.altacommerce.integration.melhor_envio.calculate.response;

public record AdditionalServicesResponseDTO(
        Boolean receipt,
        Boolean own_hand,
        Boolean collect
) {
}
