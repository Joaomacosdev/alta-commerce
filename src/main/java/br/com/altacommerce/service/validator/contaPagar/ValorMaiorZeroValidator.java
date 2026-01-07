package br.com.altacommerce.service.validator.contaPagar;

import br.com.altacommerce.dto.request.ContaPagarRequestDTO;
import br.com.altacommerce.infra.exception.BusinessException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ValorMaiorZeroValidator implements ValidatorContaPagar{
    @Override
    public void validate(ContaPagarRequestDTO dto) {
        if (dto.valorTotal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessException("O valor da conta deve ser maior que zero.");
        }
    }
}
