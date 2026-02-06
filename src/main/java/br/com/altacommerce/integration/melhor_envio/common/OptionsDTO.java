package br.com.altacommerce.integration.melhor_envio.common;

public record OptionsDTO(
        Double insurance_value,
        Boolean receipt,
        Boolean own_hand,
        Boolean reverse,
        Boolean non_commercial


) {
}
