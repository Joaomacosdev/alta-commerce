package br.com.altacommerce.integration.melhor_envio.cart.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public record ShipmentResponseDTO(
        String id,
        String protocol,

        @JsonProperty("service_id")
        Integer serviceId,

        @JsonProperty("agency_id")
        Integer agencyId,

        String contract,

        @JsonProperty("service_code")
        String serviceCode,

        BigDecimal quote,
        BigDecimal price,
        String coupon,
        BigDecimal discount,

        @JsonProperty("delivery_min")
        Integer deliveryMin,

        @JsonProperty("delivery_max")
        Integer deliveryMax,

        String status,
        String reminder,

        @JsonProperty("insurance_value")
        Integer insuranceValue,

        String weight,
        String width,
        String height,
        String length,
        String diameter,
        String format,

        @JsonProperty("billed_weight")
        BigDecimal billedWeight,

        Boolean receipt,

        @JsonProperty("own_hand")
        Boolean ownHand,

        Boolean collect,

        @JsonProperty("collect_scheduled_at")
        String collectScheduledAt,

        Boolean reverse,

        @JsonProperty("non_commercial")
        Boolean nonCommercial,

        @JsonProperty("authorization_code")
        String authorizationCode,

        Object tracking,          // ← pode ser null ou objeto
        Object selfTracking,      // ← pode ser null ou objeto
        Object deliveryReceipt,   // ← pode ser null ou objeto
        Object additionalInfo,    // ← pode ser null ou objeto

        @JsonProperty("cte_key")
        String cteKey,

        @JsonProperty("paid_at")
        String paidAt,

        @JsonProperty("generated_at")
        String generatedAt,

        @JsonProperty("posted_at")
        String postedAt,

        @JsonProperty("delivered_at")
        String deliveredAt,

        @JsonProperty("canceled_at")
        String canceledAt,

        @JsonProperty("suspended_at")
        String suspendedAt,

        @JsonProperty("expired_at")
        String expiredAt,

        @JsonProperty("created_at")
        String createdAt,

        @JsonProperty("updated_at")
        String updatedAt,

        @JsonProperty("parse_pi_at")
        String parsePiAt,

        List<ProductResponseDTO> products,
        List<VolumeResponseDTO> volumes
) {
}
