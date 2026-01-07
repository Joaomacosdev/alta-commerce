package br.com.altacommerce.service.validator.contaPagar;

import br.com.altacommerce.dto.request.ContaPagarRequestDTO;
import br.com.altacommerce.infra.exception.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class ValorIgualMaiorValorTotalValidator implements ValidatorContaPagar{
    @Override
    public void validate(ContaPagarRequestDTO dto) {
        if (dto.valorDesconto().compareTo(dto.valorTotal()) >= 0){
            throw new BusinessException("O valor do desconto não pode ser maior ou igual ao valor total");

        }
    }
}
