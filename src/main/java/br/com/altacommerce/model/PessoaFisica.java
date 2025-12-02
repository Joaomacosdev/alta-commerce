package br.com.altacommerce.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa{

    @Column(nullable = false)
    private String cpf;

    private LocalDate dataNascimento;

    public PessoaFisica() {
    }

    public PessoaFisica(String cpf, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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
