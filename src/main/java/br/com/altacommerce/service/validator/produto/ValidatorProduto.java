package br.com.altacommerce.service.validator.produto;

import br.com.altacommerce.dto.request.ProdutoRequestDTO;

public interface ValidatorProduto {
    void validate(ProdutoRequestDTO dto);
}
