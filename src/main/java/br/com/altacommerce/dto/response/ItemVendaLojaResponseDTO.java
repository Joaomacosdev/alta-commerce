package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.ItemVendaLoja;

import java.util.List;

public record ItemVendaLojaResponseDTO(


        Double quantidade,
        ProdutoResponseDTO produto
) {
    public ItemVendaLojaResponseDTO(List<ItemVendaLoja> itemVendaLojas) {
        this(itemVendaLojas.getFirst().getQuantidade(), new ProdutoResponseDTO(itemVendaLojas.getFirst().getProduto()));
    }
}
