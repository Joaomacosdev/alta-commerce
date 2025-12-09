package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.Acesso;

public record AcessoResponseDTO(
        Long id,
        String descricao
) {
    public AcessoResponseDTO(Acesso acesso) {
        this(acesso.getId(), acesso.getDescricao());
    }
}
