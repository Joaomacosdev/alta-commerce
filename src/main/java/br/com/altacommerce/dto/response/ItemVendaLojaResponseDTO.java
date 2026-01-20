package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.ItemVendaLoja;

import java.util.List;

public record ItemVendaLojaResponseDTO(


        Double quantidade,
        ProdutoResponseDTO produto
) {
    public ItemVendaLojaResponseDTO(ItemVendaLoja itemVendaLoja) {
        this(
                itemVendaLoja.getQuantidade(),
                new ProdutoResponseDTO(itemVendaLoja.getProduto())
        );
    }
}
