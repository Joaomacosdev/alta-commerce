package br.com.altacommerce.integration.melhor_envio.common;

import java.util.List;

public record OrderDTO(
        String id,
        String protocol,
        Integer service_id,
        Integer agency_id,
        String contract,
        String service_code,
        Double quote,
        Double price,
        String coupon,
        Double discount,
        Integer delivery_min,
        Integer delivery_max,
        String status,
        String reminder,
        Integer insurance_value,

        String weight,
        String width,
        String height,
        String length,
        String diameter,
        String format,
        Double billed_weight,

        Boolean receipt,
        Boolean own_hand,
        Boolean collect,
        String collect_scheduled_at,
        Boolean reverse,
        Boolean non_commercial,

        String authorization_code,
        String tracking,
        String self_tracking,
        String delivery_receipt,
        String additional_info,
        String cte_key,

        String paid_at,
        String generated_at,
        String posted_at,
        String delivered_at,
        String canceled_at,
        String suspended_at,
        String expired_at,
        String created_at,
        String updated_at,
        String parse_pi_at,

//        FromDTO from,
//        ToDTO to,
//        ServiceDTO service,
//        AgencyDTO agency,
//        InvoiceDTO invoice,

        List<TagDTO> tags,
        List<ProductDTO> products
) {
}
