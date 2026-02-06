package br.com.altacommerce.integration.melhor_envio.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FromDTO(
        String name,
        String email,
        String phone,
        String document,

        @JsonProperty("company_document")
        String companyDocument,

        @JsonProperty("state_register")
        String stateRegister,

        @JsonProperty("economic_activity_code")
        String economicActivityCode,

        String address,
        String complement,
        String number,
        String district,
        String city,

        @JsonProperty("postal_code")
        String postalCode,

        @JsonProperty("state_abbr")
        String stateAbbr
) {
}
