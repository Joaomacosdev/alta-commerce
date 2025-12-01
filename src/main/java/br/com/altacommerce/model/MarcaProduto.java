package br.com.altacommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "marca_produto")
public class MarcaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDesc;

    public MarcaProduto() {
    }

    public MarcaProduto(Long id, String nomeDesc) {
        this.id = id;
        this.nomeDesc = nomeDesc;
    }

    public Long getId() {
        return id;
    }

    public MarcaProduto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNomeDesc() {
        return nomeDesc;
    }

    public MarcaProduto setNomeDesc(String nomeDesc) {
        this.nomeDesc = nomeDesc;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MarcaProduto that = (MarcaProduto) object;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
