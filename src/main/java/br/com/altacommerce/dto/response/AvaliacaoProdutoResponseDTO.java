package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.AvaliacaoProduto;

public record AvaliacaoProdutoResponseDTO(

        Long id,
        String descricao,
        Integer nota,
        PessoaResponseDTO pessoa,
        ProdutoResponseDTO produto,
        PessoaJuridicaResponseDTO empresa
) {
        public AvaliacaoProdutoResponseDTO(AvaliacaoProduto avaliacaoProduto) {
                this(avaliacaoProduto.getId(),
                        avaliacaoProduto.getDescricao(),
                        avaliacaoProduto.getNota(),
                        new PessoaResponseDTO(avaliacaoProduto.getPessoa()),
                        new ProdutoResponseDTO(avaliacaoProduto.getProduto()),
                        new PessoaJuridicaResponseDTO(avaliacaoProduto.getEmpresa()));
        }
}
