package br.com.altacommerce.dto.melhor_envio.request;

public record VolumeDTO(
        Integer height,
        Integer width,
        Integer length,
        Float weight
) {
}
