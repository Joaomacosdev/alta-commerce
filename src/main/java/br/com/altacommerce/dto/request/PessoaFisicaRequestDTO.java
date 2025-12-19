package br.com.altacommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;


public record PessoaFisicaRequestDTO(
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

        @NotEmpty(message = "Ao menos um endereço é obrigatório")
        @Valid
        List<EnderecoRequestDTO> enderecoRequestDTOS,

        @NotBlank(message = "CPF é obrigatório")
        @Pattern(
                regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$",
                message = "CPF deve estar no formato XXX.XXX.XXX-XX ou conter 11 dígitos"
        )
                String cpf,

        @NotNull
        @Past
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento
) {
}
