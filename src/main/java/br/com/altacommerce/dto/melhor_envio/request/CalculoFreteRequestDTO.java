package br.com.altacommerce.dto.melhor_envio.request;

import java.util.List;

public record CalculoFreteRequestDTO(
        PostalCodeRequestDTO from,
        PostalCodeRequestDTO to,
        List<ProductRequestDTO> products,
        OptionsRequestDTO options,
        String services) {
}
