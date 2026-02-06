package br.com.altacommerce.integration.melhor_envio.common;

public record OrderReasonDTO(
        String id,
        String protocol,
        String reason
) {
}
