package br.com.altacommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "item_venda_loja")
public class ItemVendaLoja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "vd_cp_loja_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "vd_cp_loja_fk"))
    private VdCpLoja vdCpLoja;

    private Double quantidade;

    public ItemVendaLoja() {
    }

    public ItemVendaLoja(Long id, Produto produto, VdCpLoja vdCpLoja, Double quantidade) {
        this.id = id;
        this.produto = produto;
        this.vdCpLoja = vdCpLoja;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public ItemVendaLoja setId(Long id) {
        this.id = id;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public ItemVendaLoja setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public VdCpLoja getVdCpLoja() {
        return vdCpLoja;
    }

    public ItemVendaLoja setVdCpLoja(VdCpLoja vdCpLoja) {
        this.vdCpLoja = vdCpLoja;
        return this;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public ItemVendaLoja setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ItemVendaLoja that = (ItemVendaLoja) object;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
