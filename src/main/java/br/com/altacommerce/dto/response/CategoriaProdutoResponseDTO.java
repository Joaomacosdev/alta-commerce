package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.CategoriaProduto;
import br.com.altacommerce.model.PessoaJuridica;

public record CategoriaProdutoResponseDTO(

        Long id,
        String nomeDesc,
        PessoaJuridica empresa
) {
        public CategoriaProdutoResponseDTO(CategoriaProduto categoriaProduto) {
                this(categoriaProduto.getId(), categoriaProduto.getNomeDesc(), categoriaProduto.getEmpresa());
        }
}
