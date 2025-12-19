package br.com.altacommerce.service.validator.pessoaFisica;

import br.com.altacommerce.dto.request.PessoaFisicaRequestDTO;
import br.com.altacommerce.infra.exception.BusinessException;
import br.com.altacommerce.util.ValidaCpfUtil;
import org.springframework.stereotype.Component;

@Component
public class CpfValidator implements ValidatorPessoaFisica{
    @Override
    public void validate(PessoaFisicaRequestDTO dto) {
        if (dto.cpf() == null || dto.cpf().isBlank()) {
            throw new BusinessException("CPF é obrigatório");
        }

        String cpf = dto.cpf().replaceAll("\\D", "");

        if (!ValidaCpfUtil.isCPF(cpf)) {
            throw new BusinessException("CPF inválido");
        }
    }
}
