package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.Endereco;
import br.com.altacommerce.model.PessoaJuridica;
import br.com.altacommerce.model.enums.TipoPessoa;

import java.util.List;


public record PessoaJuridicaResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        TipoPessoa tipoPessoa,
        List<Endereco> enderecos,
        String cnpj,
        String inscEstadual,
        String inscMunicipal,
        String nomeFantasia,
        String razaoSocial,
        String categoria
) {
    public PessoaJuridicaResponseDTO(PessoaJuridica pessoaJuridica) {
        this(
                pessoaJuridica.getId(),
                pessoaJuridica.getNome(),
                pessoaJuridica.getEmail(),
                pessoaJuridica.getTelefone(),
                pessoaJuridica.getTipoPessoa(),
                pessoaJuridica.getEnderecos(),
                pessoaJuridica.getCnpj(),
                pessoaJuridica.getInscEstadual(),
                pessoaJuridica.getInscMunicipal(),
                pessoaJuridica.getNomeFantasia(),
                pessoaJuridica.getRazaoSocial(),
                pessoaJuridica.getCategoria()
        );
    }
}
