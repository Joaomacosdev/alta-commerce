package br.com.altacommerce.service.validator.pessoaFisica;

import br.com.altacommerce.dto.request.PessoaFisicaRequestDTO;

public interface ValidatorPessoaFisica {
    void validate(PessoaFisicaRequestDTO dto);
}
