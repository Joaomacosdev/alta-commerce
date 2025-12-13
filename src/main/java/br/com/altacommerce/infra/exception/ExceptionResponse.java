package br.com.altacommerce.infra.exception;

import java.time.Instant;

public record ExceptionResponse(
        Instant timestamp,
        String message,
        String details
) {
}
