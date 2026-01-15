package br.com.altacommerce.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record VdCpLojaRequestDTO(
        @NotNull(message = "O valor do frete é obrigatório")
        @DecimalMin(value = "0.00", inclusive = true, message = "O valor do frete não pode ser negativo")
        BigDecimal valorFrete,

        @NotNull(message = "Os dias de entrega são obrigatórios")
        @Min(value = 0, message = "Os dias de entrega não podem ser negativos")
        Integer diasEntrega,
        @NotNull(message = "A data de entrega é obrigatória")
        LocalDate dataEntrega,

        @NotNull(message = "O valor total é obrigatório")
        @DecimalMin(value = "0.00", inclusive = true, message = "O valor total não pode ser negativo")
        BigDecimal valorTotal,

        @DecimalMin(value = "0.00", inclusive = true, message = "O valor de desconto não pode ser negativo")
        BigDecimal valorDesconto,

        @NotNull(message = "A pessoa é obrigatória")
        Long pessoaId,

        @NotNull(message = "O endereço de entrega é obrigatório")
        Long enderecoEntregaId,

        @NotNull(message = "O endereço de cobrança é obrigatório")
        Long enderecoCobrancaId,

        @NotNull(message = "A forma de pagamento é obrigatória")
        Long formaPagamentoId,



        Long cupomDescontoId,

        @NotNull(message = "A empresa é obrigatória")
        Long empresaId,

        @NotNull(message = "A nota fiscal da venda é obrigatória")
        @Valid
        NotaFiscalVendaRequestDTO notaFiscalVenda,

        @NotNull()
        @NotEmpty(message = "A lista de itens não pode estar vazia")
        @Valid
        List<ItemVendaLojaRequestDTO> itens
) {
}
