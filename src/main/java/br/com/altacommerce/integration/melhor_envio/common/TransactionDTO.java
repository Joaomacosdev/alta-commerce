package br.com.altacommerce.integration.melhor_envio.common;

public record TransactionDTO(
        String id,
        String protocol,
        Double total,
        Double discount,
        String status,
        String paid_at,
        String canceled_at,
        String created_at,
        String updated_at,
        String payment
) {
}
