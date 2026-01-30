package br.com.altacommerce.dto.melhor_envio.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ToDTO(
        String name,
        String email,
        String phone,
        String document,

        @JsonProperty("state_register")
        String stateRegister,

        String address,
        String complement,
        String number,
        String district,
        String city,

        @JsonProperty("postal_code")
        String postalCode,

        @JsonProperty("country_id")
        String countryId,

        @JsonProperty("state_abbr")
        String stateAbbr
) {
}
