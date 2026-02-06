package br.com.altacommerce.integration.melhor_envio.calculate.response;

import java.util.List;

public record CalculoFreteResponseDTO(
        List<ServiceResponseDTO> services

) {
}
