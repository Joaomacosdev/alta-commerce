package br.com.altacommerce.integration.melhor_envio.print.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public record OrderRequestDTO(
        @NotNull(message = "O modo é obrigatório")
        String mode, // private | public

        @NotEmpty(message = "A lista de pedidos não pode estar vazia")
        List<String> orders
) {
}
