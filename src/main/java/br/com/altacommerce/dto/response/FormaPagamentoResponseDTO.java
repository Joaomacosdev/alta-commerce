package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.FormaPagamento;

public record FormaPagamentoResponseDTO(
        Long id,
        String descricao
) {
    public FormaPagamentoResponseDTO(FormaPagamento formaPagamento) {
        this(formaPagamento.getId(), formaPagamento.getDescricao());
    }
}
