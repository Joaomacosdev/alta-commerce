package br.com.altacommerce.dto.melhor_envio.request;

public record OptionsDTO(
        Double insurance_value,
        Boolean receipt,
        Boolean own_hand,
        Boolean reverse,
        Boolean non_commercial


) {
}
