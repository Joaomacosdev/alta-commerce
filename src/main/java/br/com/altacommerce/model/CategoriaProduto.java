package br.com.altacommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "categoria_produto")
public class CategoriaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_desc", nullable = false)
    private String nomeDesc;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_fk"))
    private PessoaJuridica empresa;

    public CategoriaProduto() {
    }

    public CategoriaProduto(Long id, String nomeDesc) {
        this.id = id;
        this.nomeDesc = nomeDesc;
    }

    public Long getId() {
        return id;
    }

    public CategoriaProduto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNomeDesc() {
        return nomeDesc;
    }

    public CategoriaProduto setNomeDesc(String nomeDesc) {
        this.nomeDesc = nomeDesc;
        return this;
    }

    public PessoaJuridica getEmpresa() {
        return empresa;
    }

    public CategoriaProduto setEmpresa(PessoaJuridica empresa) {
        this.empresa = empresa;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CategoriaProduto that = (CategoriaProduto) object;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
