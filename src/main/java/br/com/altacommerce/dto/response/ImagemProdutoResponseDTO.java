package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.ImagemProduto;

import java.util.List;

public record ImagemProdutoResponseDTO(

        String imagemOriginal,
        String imagemMiniatura
) {
        public ImagemProdutoResponseDTO(List<ImagemProduto> imagemProdutos) {
                this(imagemProdutos.getFirst().getImagemOriginal(), imagemProdutos.getFirst().getImagemMiniatura());
        }

        public ImagemProdutoResponseDTO(ImagemProduto imagemProduto) {
                this(imagemProduto.getImagemOriginal(), imagemProduto.getImagemMiniatura());
        }
}
