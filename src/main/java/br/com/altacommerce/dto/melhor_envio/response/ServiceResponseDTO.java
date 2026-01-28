package br.com.altacommerce.dto.melhor_envio.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ServiceResponseDTO(
        Integer id,
        String name,
        String price,
        String custom_price,
        String discount,
        String currency,
        Integer delivery_time,
        DeliveryRangeResponseDTO delivery_range,
        Integer custom_delivery_time,
        DeliveryRangeResponseDTO custom_delivery_range,
        List<PackageResponseDTO> packages,
        List<ProductResponseDTO> products,
        AdditionalServicesResponseDTO additional_services,
        CompanyReponseDTO company
) {
}
