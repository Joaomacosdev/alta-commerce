package br.com.altacommerce.service.validator.pessoaJuridica;

import br.com.altacommerce.dto.request.PessoaJuridicaRequestDTO;

public interface ValidatorPessoaJuridica {
    void validate(PessoaJuridicaRequestDTO dto);
}
