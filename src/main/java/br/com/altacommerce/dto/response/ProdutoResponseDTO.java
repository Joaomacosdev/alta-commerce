package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.CategoriaProduto;
import br.com.altacommerce.model.MarcaProduto;
import br.com.altacommerce.model.PessoaJuridica;
import br.com.altacommerce.model.Produto;

import java.math.BigDecimal;

public record ProdutoResponseDTO(
        Long id,
        String tipoUnidade,
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
        PessoaJuridica empresaId,
        CategoriaProduto categoriaProduto,
        MarcaProduto marcaProduto
) {
    public ProdutoResponseDTO(Produto produto) {
        this(produto.getId(), produto.getTipoUnidade(), produto.getNome(), produto.getDescricao(), produto.getPeso(),
                produto.getLargura(), produto.getAltura(), produto.getProfundidade(), produto.getValorVenda(), produto.getQtdEstoque(),
                produto.getQtdAlertaEstoque(), produto.getLinkyoutube(), produto.getAlertaQtdEstoque(), produto.getQtdClique(),
                produto.getAtivo(), produto.getEmpresa(), produto.getCategoriaProduto(), produto.getMarcaProduto());
    }
}
