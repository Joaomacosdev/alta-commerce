package br.com.altacommerce.model.enums;

public enum TipoPessoa {
    JURIDICA("Jurídica"),
    FISICA("Física ");

    private String descricao;

    private TipoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
