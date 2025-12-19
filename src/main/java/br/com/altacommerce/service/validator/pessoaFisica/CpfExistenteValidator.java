package br.com.altacommerce.service.validator.pessoaFisica;

import br.com.altacommerce.dto.request.PessoaFisicaRequestDTO;
import br.com.altacommerce.repository.PessoaFisicaRepository;
import org.springframework.stereotype.Component;

@Component
public class CpfExistenteValidator implements ValidatorPessoaFisica{

    private final PessoaFisicaRepository pessoaFisicaRepository;

    public CpfExistenteValidator(PessoaFisicaRepository pessoaFisicaRepository) {
        this.pessoaFisicaRepository = pessoaFisicaRepository;
    }

    @Override
    public void validate(PessoaFisicaRequestDTO dto) {
        pessoaFisicaRepository.existsByCpf(dto.cpf());
    }
}
