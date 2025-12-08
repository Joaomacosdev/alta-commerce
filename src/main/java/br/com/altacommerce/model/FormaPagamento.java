package br.com.altacommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;

    public FormaPagamento() {
    }

    public FormaPagamento(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public FormaPagamento setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public FormaPagamento setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        FormaPagamento that = (FormaPagamento) object;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
