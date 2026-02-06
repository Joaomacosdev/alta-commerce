package br.com.altacommerce.integration.melhor_envio.calculate.response;

public record PriceResponseDTO(
        Double freight,
        Double insurance,
        Double discount,
        Double total
) {
}
