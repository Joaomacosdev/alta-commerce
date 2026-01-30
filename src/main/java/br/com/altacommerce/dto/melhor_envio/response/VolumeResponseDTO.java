package br.com.altacommerce.dto.melhor_envio.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VolumeResponseDTO(
        Integer id,
        String height,
        String width,
        String length,
        String diameter,
        String weight,
        String format,

        @JsonProperty("created_at")
        String createdAt,

        @JsonProperty("updated_at")
        String updatedAt
) {
}
