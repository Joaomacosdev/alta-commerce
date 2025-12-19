package br.com.altacommerce.service.validator.pessoaJuridica;

import br.com.altacommerce.dto.request.PessoaJuridicaRequestDTO;
import br.com.altacommerce.infra.exception.BusinessException;
import br.com.altacommerce.repository.PessoaJuridicaRepository;
import org.springframework.stereotype.Component;

@Component
public class CnpjExistenteValidator implements ValidatorPessoaJuridica {

    private final PessoaJuridicaRepository pessoaJuridicaRepository;

    public CnpjExistenteValidator(PessoaJuridicaRepository pessoaJuridicaRepository) {
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
    }

    @Override
    public void validate(PessoaJuridicaRequestDTO dto) {
        if (pessoaJuridicaRepository.existsByCnpj(dto.cnpj())) {
            throw new BusinessException("CNPJ já cadastrado");
        }
    }
}
