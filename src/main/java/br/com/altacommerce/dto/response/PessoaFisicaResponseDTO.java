package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.Endereco;
import br.com.altacommerce.model.PessoaFisica;

import java.time.LocalDate;
import java.util.List;


public record PessoaFisicaResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        List<Endereco> enderecos,
        LocalDate dataNascimento
) {
    public PessoaFisicaResponseDTO(PessoaFisica pessoaFisica) {
        this(pessoaFisica.getId(), pessoaFisica.getNome(), pessoaFisica.getEmail(), pessoaFisica.getTelefone(), pessoaFisica.getEnderecos(), pessoaFisica.getDataNascimento());
    }
}
