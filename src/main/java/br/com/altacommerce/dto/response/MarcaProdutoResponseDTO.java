package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.MarcaProduto;

public record MarcaProdutoResponseDTO(

        Long id,
        String nomeDesc,
        PessoaJuridicaResponseDTO empresa
) {
    public MarcaProdutoResponseDTO(MarcaProduto marcaProduto) {
        this(marcaProduto.getId(), marcaProduto.getNomeDesc(), new PessoaJuridicaResponseDTO(marcaProduto.getEmpresa())
        );
    }
}
