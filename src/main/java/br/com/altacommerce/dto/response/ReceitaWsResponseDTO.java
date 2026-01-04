package br.com.altacommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record ReceitaWsResponseDTO(

        String abertura,
        String situacao,
        String tipo,
        String nome,
        String fantasia,
        String porte,

        @JsonProperty("natureza_juridica")
        String naturezaJuridica,



        String logradouro,
        String numero,
        String complemento,
        String municipio,
        String bairro,
        String uf,
        String cep,
        String email,
        String telefone,

        @JsonProperty("data_situacao")
        String dataSituacao,

        String cnpj,

        @JsonProperty("ultima_atualizacao")
        Instant ultimaAtualizacao,

        String status,
        String efr,

        @JsonProperty("motivo_situacao")
        String motivoSituacao,

        @JsonProperty("situacao_especial")
        String situacaoEspecial,

        @JsonProperty("data_situacao_especial")
        String dataSituacaoEspecial,

        @JsonProperty("capital_social")
        String capitalSocial


) {
}
