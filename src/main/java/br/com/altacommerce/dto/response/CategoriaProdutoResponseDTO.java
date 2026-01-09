package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.CategoriaProduto;
import br.com.altacommerce.model.PessoaJuridica;

public record CategoriaProdutoResponseDTO(

        Long id,
        String nomeDesc,
        PessoaJuridicaResponseDTO empresa
) {
        public CategoriaProdutoResponseDTO(CategoriaProduto categoriaProduto) {
                this(categoriaProduto.getId(), categoriaProduto.getNomeDesc(), new PessoaJuridicaResponseDTO(categoriaProduto.getEmpresa()));
        }
}
