package br.com.altacommerce.integration.melhor_envio.common;

public record ProductRequestDTO(
        String id,
        Integer width,          // cm
        Integer height,         // cm
        Integer length,         // cm
        Double weight,          // kg
        Double insurance_value, // BRL
        Integer quantity
) {
}
