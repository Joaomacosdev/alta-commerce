package br.com.altacommerce.integration.melhor_envio.calculate.request;

import br.com.altacommerce.integration.melhor_envio.common.ProductRequestDTO;

import java.util.List;

public record CalculoFreteRequestDTO(
        PostalCodeRequestDTO from,
        PostalCodeRequestDTO to,
        List<ProductRequestDTO> products,
        OptionsRequestDTO options,
        String services) {
}
