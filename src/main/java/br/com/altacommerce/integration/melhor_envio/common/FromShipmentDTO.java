package br.com.altacommerce.integration.melhor_envio.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FromShipmentDTO(
        @JsonProperty("name")
        String name,

        @JsonProperty("email")
        String email,

        @JsonProperty("phone")
        String phone,

        @JsonProperty("document")
        String document,

        @JsonProperty("company_document")
        String companyDocument,

        @JsonProperty("state_register")
        String stateRegister,

        @JsonProperty("economic_activity_code")
        String economicActivityCode,

        @JsonProperty("address")
        String address,

        @JsonProperty("complement")
        String complement,

        @JsonProperty("number")
        String number,

        @JsonProperty("district")
        String district,

        @JsonProperty("city")
        String city,

        @JsonProperty("postal_code")
        String postalCode,

        @JsonProperty("state_abbr")
        String stateAbbr
) {
}
