package br.com.altacommerce.service.validator.contaPagar;

import br.com.altacommerce.dto.request.ContaPagarRequestDTO;

public interface ValidatorContaPagar {
    void validate(ContaPagarRequestDTO dto);
}
