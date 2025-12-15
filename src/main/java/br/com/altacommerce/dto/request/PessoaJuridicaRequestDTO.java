package br.com.altacommerce.dto.request;

import br.com.altacommerce.model.enums.TipoPessoa;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;


public record PessoaJuridicaRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 2, max = 255, message = "O nome deve ter entre 2 e 255 caracteres")
        String nome,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @Pattern(
                regexp = "^\\+55\\s?\\d{2}\\s?\\d{4,5}-?\\d{4}$",
                message = "Telefone deve estar no formato +55 XX XXXXX-XXXX"
        )
        String telefone,

        @Valid
        List<EnderecoRequestDTO> enderecoRequestDTOS,



        @NotBlank(message = "O CNPJ é obrigatório")
        @Pattern(
                regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$",
                message = "CNPJ deve estar no formato XX.XXX.XXX/XXXX-XX"
        )
        String cnpj,

        @Pattern(
                regexp = "^\\d{9}$",
                message = "Inscrição estadual deve ter 9 dígitos"
        )
        String inscEstadual,

        @Pattern(
                regexp = "^\\d{8,12}$",
                message = "Inscrição municipal deve ter entre 8 e 12 dígitos"
        )
        String inscMunicipal,

        @Size(max = 255, message = "Nome fantasia deve ter no máximo 255 caracteres")
        String nomeFantasia,

        @NotBlank(message = "Razão social é obrigatória")
        @Size(min = 2, max = 255, message = "Razão social deve ter entre 2 e 255 caracteres")
        String razaoSocial,

        @NotBlank(message = "Categoria é obrigatória")
        @Size(max = 50, message = "Categoria deve ter no máximo 50 caracteres")
        String categoria
) {
}
