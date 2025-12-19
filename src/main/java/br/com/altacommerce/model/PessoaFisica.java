package br.com.altacommerce.model;

import br.com.altacommerce.dto.request.PessoaFisicaRequestDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa {

    @Column(nullable = false, unique = true)
    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    public PessoaFisica() {
    }

    public PessoaFisica(PessoaFisicaRequestDTO dto) {
        super(dto.nome(), dto.email(), dto.telefone(), dto.enderecoRequestDTOS().stream()
                .map(Endereco::new).toList());
        this.cpf = dto.cpf();
        this.dataNascimento = dto.dataNascimento();
    }

    public String getCpf() {
        return cpf;
    }

    public PessoaFisica setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public PessoaFisica setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }
}
