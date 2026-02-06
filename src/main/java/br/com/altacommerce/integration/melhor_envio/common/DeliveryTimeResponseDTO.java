package br.com.altacommerce.integration.melhor_envio.common;

public record DeliveryTimeResponseDTO(
        Integer days,
        String estimated_date
) {
}
