package br.com.altacommerce.service.validator.marcaProduto;

import br.com.altacommerce.dto.request.MarcaProdutoRequestDTO;

public interface ValidatorMarcaProduto {
    void validate(MarcaProdutoRequestDTO dto);
}
