package br.com.altacommerce.dto.response;

public record CepResponseDTO(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf
) {
}
