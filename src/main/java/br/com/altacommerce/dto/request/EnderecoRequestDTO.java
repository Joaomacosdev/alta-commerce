package br.com.altacommerce.dto.request;

import br.com.altacommerce.model.Pessoa;
import br.com.altacommerce.model.enums.TipoEndereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public record EnderecoRequestDTO(

        @NotBlank(message = "Rua/Logradouro é obrigatório")
        @Size(min = 2, max = 255, message = "Rua/Logradouro deve ter entre 2 e 255 caracteres")
        String ruaLogradouro,

        @NotBlank(message = "CEP é obrigatório")
        @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "CEP deve estar no formato 00000-000")
        String cep,

        @NotBlank(message = "Número é obrigatório")
        @Size(max = 10, message = "Número deve ter no máximo 10 caracteres")
        String numero,

        @Size(max = 50, message = "Complemento deve ter no máximo 50 caracteres")
        String complemento,

        @NotBlank(message = "Bairro é obrigatório")
        @Size(min = 2, max = 100, message = "Bairro deve ter entre 2 e 100 caracteres")
        String bairro,

        @NotBlank(message = "UF é obrigatório")
        @Pattern(regexp = "^(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)$",
                message = "UF inválida")
        String uf,

        @NotBlank(message = "Cidade é obrigatória")
        @Size(min = 2, max = 100, message = "Cidade deve ter entre 2 e 100 caracteres")
        String cidade,

        Pessoa pessoa, // será setado no serviço, não precisa de validação

        @NotNull(message = "Tipo de endereço é obrigatório")
        TipoEndereco tipoEndereco
) {
}
