package br.com.altacommerce.integration.melhor_envio.checkout.response;

import br.com.altacommerce.integration.melhor_envio.common.OrderDTO;
import br.com.altacommerce.integration.melhor_envio.common.PurchaseDTO;
import br.com.altacommerce.integration.melhor_envio.common.ReasonDTO;
import br.com.altacommerce.integration.melhor_envio.common.TransactionDTO;

import java.util.List;

public record ShipmentCheckoutResponseDTO(
        PurchaseDTO purchase,
        List<TransactionDTO> transactions,
        ReasonDTO reason,
        List<OrderDTO> orders,

        String digitable,
        String redirect,
        String message,
        String token,
        String payment_id

) {
}
