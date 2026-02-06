package br.com.altacommerce.integration.melhor_envio.common;

import java.util.List;

public record ReasonDTO(
        List<OrderReasonDTO> orders

) {
}
