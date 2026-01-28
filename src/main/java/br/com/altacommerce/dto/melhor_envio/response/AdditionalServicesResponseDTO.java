package br.com.altacommerce.dto.melhor_envio.response;

public record AdditionalServicesResponseDTO(
        Boolean receipt,
        Boolean own_hand,
        Boolean collect
) {
}
