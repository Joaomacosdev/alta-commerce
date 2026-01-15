package br.com.altacommerce.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record NotaFiscalVendaRequestDTO(
        @NotBlank(message = "O número do documento é obrigatório")
        @Size(max = 60, message = "O número do documento deve ter no máximo 60 caracteres")
        String numero,

        @NotBlank(message = "A série é obrigatória")
        @Size(max = 20, message = "A série deve ter no máximo 20 caracteres")
        String serie,

        @NotBlank(message = "O tipo do documento é obrigatório")
        @Size(max = 30, message = "O tipo do documento deve ter no máximo 30 caracteres")
        String tipo,

        @NotBlank(message = "O XML é obrigatório")
        String xml,

        @NotBlank(message = "O PDF é obrigatório")
        String pdf,

        @NotNull(message = "O ID da empresa é obrigatório")
        Long empresaId

) {
}
