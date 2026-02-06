package br.com.altacommerce.integration.melhor_envio.cart.request;

import br.com.altacommerce.integration.melhor_envio.common.*;

import java.util.List;

public record ShipmentRequestDTO(
        Integer service,
        Integer agency,
        FromShipmentDTO from,
        FromShipmentDTO to,
        List<ProductDTO> products,
        List<VolumeDTO> volumes,
        OptionsDTO options,
        InvoiceDTO invoice,
        String platform,
        List<TagDTO> tags
) {
}
