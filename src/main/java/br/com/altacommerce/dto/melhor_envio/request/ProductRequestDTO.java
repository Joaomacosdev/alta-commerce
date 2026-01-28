package br.com.altacommerce.dto.melhor_envio.request;

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
