package br.com.altacommerce.service.validator.pessoaFisica;

import br.com.altacommerce.dto.request.PessoaFisicaRequestDTO;
import br.com.altacommerce.repository.PessoaFisicaRepository;
import org.springframework.stereotype.Component;

@Component
public class EmailPessoaFisicaValidator implements ValidatorPessoaFisica{

    private final PessoaFisicaRepository pessoaFisicaRepository;

    public EmailPessoaFisicaValidator(PessoaFisicaRepository pessoaFisicaRepository) {
        this.pessoaFisicaRepository = pessoaFisicaRepository;
    }

    @Override
    public void validate(PessoaFisicaRequestDTO dto) {
        pessoaFisicaRepository.existsByEmail(dto.email());
    }
}
