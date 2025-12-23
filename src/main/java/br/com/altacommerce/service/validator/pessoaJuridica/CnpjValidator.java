package br.com.altacommerce.service.validator.pessoaJuridica;

import br.com.altacommerce.dto.request.PessoaJuridicaRequestDTO;
import br.com.altacommerce.infra.exception.BusinessException;
import br.com.altacommerce.util.DocumentoUtils;
import br.com.altacommerce.util.ValidaCnpjUtil;
import org.springframework.stereotype.Component;

@Component
public class CnpjValidator implements ValidatorPessoaJuridica{

    @Override
    public void validate(PessoaJuridicaRequestDTO dto) {

        String cnpjLimpo = DocumentoUtils.somenteNumeros(dto.cnpj());

        if (!ValidaCnpjUtil.isCNPJ(cnpjLimpo)) {
            throw new BusinessException("CNPJ inválido");
        }
    }
}