package br.com.altacommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "avaliacao_produto")
public class AvaliacaoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Integer nota;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_fk"))
    private PessoaJuridica empresa;

    public AvaliacaoProduto() {
    }


    public Long getId() {
        return id;
    }

    public AvaliacaoProduto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public AvaliacaoProduto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Integer getNota() {
        return nota;
    }

    public AvaliacaoProduto setNota(Integer nota) {
        this.nota = nota;
        return this;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public AvaliacaoProduto setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public AvaliacaoProduto setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public PessoaJuridica getEmpresa() {
        return empresa;
    }

    public AvaliacaoProduto setEmpresa(PessoaJuridica empresa) {
        this.empresa = empresa;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AvaliacaoProduto that = (AvaliacaoProduto) object;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
