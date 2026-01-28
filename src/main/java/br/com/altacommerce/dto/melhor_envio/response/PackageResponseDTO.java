package br.com.altacommerce.dto.melhor_envio.response;

import java.util.List;

public record PackageResponseDTO(
        String price,
        String discount,
        String format,
        DimensionsReponseDTO dimensions,
        String weight,
        String insurance_value,
        List<ProductResponseDTO> products
) {
}
