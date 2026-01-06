package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.Pessoa;
import br.com.altacommerce.model.enums.TipoPessoa;

public record PessoaResponseDTO(

        String nome,
        String email,
        String telefone,
        TipoPessoa tipoPessoa
) {
    public PessoaResponseDTO(Pessoa pessoa) {
        this(pessoa.getNome(), pessoa.getEmail(), pessoa.getTelefone(), pessoa.getTipoPessoa());
    }
}
