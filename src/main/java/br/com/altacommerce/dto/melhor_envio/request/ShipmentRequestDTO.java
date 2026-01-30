package br.com.altacommerce.dto.melhor_envio.request;

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
