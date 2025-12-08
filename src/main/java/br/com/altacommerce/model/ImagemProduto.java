package br.com.altacommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "imagem_produto")
public class ImagemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT", nullable = false,length = 2000)
    private String imagemOriginal;
    @Column(columnDefinition = "TEXT", nullable = false,length = 2000)
    private String imagemMiniatura;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
    private Produto produto;

    public ImagemProduto() {
    }

    public ImagemProduto(Long id, String imagemOriginal, String imagemMiniatura, Produto produto) {
        this.id = id;
        this.imagemOriginal = imagemOriginal;
        this.imagemMiniatura = imagemMiniatura;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public ImagemProduto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getImagemOriginal() {
        return imagemOriginal;
    }

    public ImagemProduto setImagemOriginal(String imagemOriginal) {
        this.imagemOriginal = imagemOriginal;
        return this;
    }

    public String getImagemMiniatura() {
        return imagemMiniatura;
    }

    public ImagemProduto setImagemMiniatura(String imagemMiniatura) {
        this.imagemMiniatura = imagemMiniatura;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public ImagemProduto setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ImagemProduto that = (ImagemProduto) object;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
