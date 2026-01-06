package br.com.altacommerce.dto.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public record ContaPagarRequestDTO(

        @NotBlank(message = "A descrição é obrigatória")
        @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
        String descricao,

        @NotNull(message = "A data de vencimento é obrigatória")
        Date dtVencimento,

        Date dtPagamento,

        @NotNull(message = "O valor total é obrigatório")
        @DecimalMin(value = "0.01", message = "O valor total deve ser maior que zero")
        BigDecimal valorTotal,

        @DecimalMin(value = "0.00", message = "O valor de desconto não pode ser negativo")
        BigDecimal valorDesconto,

        @NotNull(message = "O ID da pessoa é obrigatório")
        Long pessoaId,

        @NotNull(message = "O ID do fornecedor é obrigatório")
        Long pessoaFornecedorId,

//        @NotNull(message = "O status da conta é obrigatório")
//        StatusContaPagar status,

        @NotNull(message = "O ID da empresa é obrigatório")
        Long empresaId
) {
}
