package br.com.altacommerce.dto.melhor_envio.response;

public record DeliveryTimeResponseDTO(
        Integer days,
        String estimated_date
) {
}
