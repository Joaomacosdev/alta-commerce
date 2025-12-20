package br.com.altacommerce.dto.response;

public record CepResponseDTO(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        String ibge,
        String gia,
        String ddd,
        String siafi

        ) {
}
