package br.com.altacommerce.integration.melhor_envio.calculate.response;

import br.com.altacommerce.integration.melhor_envio.common.DimensionsReponseDTO;
import br.com.altacommerce.integration.melhor_envio.cart.response.ProductResponseDTO;

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
