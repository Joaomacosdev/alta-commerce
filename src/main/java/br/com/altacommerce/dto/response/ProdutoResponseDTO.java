package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.Produto;
import br.com.altacommerce.model.enums.TipoUnidade;

import java.math.BigDecimal;

public record ProdutoResponseDTO(
        Long id,
        TipoUnidade tipoUnidade,
        String nome,
        String descricao,
        Double peso,
        Double largura,
        Double altura,
        Double profundidade,
        BigDecimal valorVenda,
        Integer qtdEstoque,
        Integer qtdAlertaEstoque,
        String linkyoutube,
        Boolean alertaQtdEstoque,
        Integer qtdClique,
        Boolean ativo,
        ImagemProdutoResponseDTO imagens,
        PessoaJuridicaResponseDTO empresa,
        CategoriaProdutoResponseDTO categoriaProduto,
        MarcaProdutoResponseDTO marcaProduto
) {
    public ProdutoResponseDTO(Produto produto) {
        this(produto.getId(), produto.getTipoUnidade(), produto.getNome(), produto.getDescricao(), produto.getPeso(),
                produto.getLargura(), produto.getAltura(), produto.getProfundidade(), produto.getValorVenda(), produto.getQtdEstoque(),
                produto.getQtdAlertaEstoque(), produto.getLinkyoutube(), produto.getAlertaQtdEstoque(), produto.getQtdClique(),
                produto.getAtivo(),
                new ImagemProdutoResponseDTO(produto.getImagemProdutos()),
                new PessoaJuridicaResponseDTO(produto.getEmpresa()),
                new CategoriaProdutoResponseDTO(produto.getCategoriaProduto()),
                new MarcaProdutoResponseDTO(produto.getMarcaProduto()));

    }
}
