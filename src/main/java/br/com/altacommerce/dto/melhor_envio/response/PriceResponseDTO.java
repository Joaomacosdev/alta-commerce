package br.com.altacommerce.dto.melhor_envio.response;

public record PriceResponseDTO(
        Double freight,
        Double insurance,
        Double discount,
        Double total
) {
}
