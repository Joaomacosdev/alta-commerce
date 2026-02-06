package br.com.altacommerce.integration.melhor_envio.checkout.request;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public record ShipmentCheckoutRequestDTO(
        @NotEmpty(message = "A lista de pedidos é obrigatória")
        List<String> orders

) {
}
