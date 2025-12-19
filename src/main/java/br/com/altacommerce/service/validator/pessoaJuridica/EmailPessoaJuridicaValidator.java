package br.com.altacommerce.service.validator.pessoaJuridica;

import br.com.altacommerce.dto.request.PessoaJuridicaRequestDTO;
import br.com.altacommerce.infra.exception.BusinessException;
import br.com.altacommerce.repository.PessoaJuridicaRepository;
import org.springframework.stereotype.Component;

@Component
public class EmailPessoaJuridicaValidator implements ValidatorPessoaJuridica{

    private final PessoaJuridicaRepository pessoaJuridicaRepository;

    public EmailPessoaJuridicaValidator(PessoaJuridicaRepository pessoaJuridicaRepository) {
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
    }

    @Override
    public void validate(PessoaJuridicaRequestDTO dto) {
        if (pessoaJuridicaRepository.existsByEmail(dto.email())) {
            throw new BusinessException("EMAIL já cadastrado");
        }
    }
}
