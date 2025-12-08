package br.com.altacommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "nota_item_produto")
public class NotaItemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nota_fiscal_compra_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "nota_fiscal_compra_fk"))
    private NotaFiscalCompra notaFiscalCompra;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
    private Produto produto;
    @Column(nullable = false)
    private Double quantidade;

    public NotaItemProduto() {
    }

    public NotaItemProduto(Long id, NotaFiscalCompra notaFiscalCompra, Produto produto, Double quantidade) {
        this.id = id;
        this.notaFiscalCompra = notaFiscalCompra;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public NotaItemProduto setId(Long id) {
        this.id = id;
        return this;
    }

    public NotaFiscalCompra getNotaFiscalCompra() {
        return notaFiscalCompra;
    }

    public NotaItemProduto setNotaFiscalCompra(NotaFiscalCompra notaFiscalCompra) {
        this.notaFiscalCompra = notaFiscalCompra;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public NotaItemProduto setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public NotaItemProduto setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        NotaItemProduto that = (NotaItemProduto) object;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
