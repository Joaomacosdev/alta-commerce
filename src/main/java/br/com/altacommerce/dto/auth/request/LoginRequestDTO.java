package br.com.altacommerce.dto.auth.request;

public record LoginRequestDTO(
        String login,
        String senha
) {
}
