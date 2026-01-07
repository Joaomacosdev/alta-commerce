package br.com.altacommerce.model;

import br.com.altacommerce.dto.request.ProdutoRequestDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoUnidade;
    @Column(nullable = false)
    private String nome;
    @Column(columnDefinition = "TEXT", nullable = false,length = 2000)
    private String descricao;
    @Column(nullable = false)
    private Double peso;
    @Column(nullable = false)
    private Double largura;
    @Column(nullable = false)
    private Double altura;
    @Column(nullable = false)
    private Double profundidade;
    @Column(nullable = false)
    private BigDecimal valorVenda;
    @Column(nullable = false)
    private Integer qtdEstoque = 0;
    private Integer qtdAlertaEstoque = 0;

    private String linkyoutube;
    private Boolean alertaQtdEstoque = false;
    private Integer qtdClique;
    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_fk"))
    private PessoaJuridica empresa;

    @ManyToOne
    @JoinColumn(name = "categoria_produto_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "categoria_produto_fk"))
    private CategoriaProduto categoriaProduto;


    @ManyToOne
    @JoinColumn(name = "marca_produto_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "marca_produto_fk"))
    private MarcaProduto marcaProduto;




    public Produto() {
    }

    public Produto(ProdutoRequestDTO dto) {
        this.tipoUnidade = dto.tipoUnidade();
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.peso = dto.peso();
        this.largura = dto.largura();
        this.altura = dto.altura();
        this.profundidade = dto.profundidade();
        this.valorVenda = dto.valorVenda();
        this.qtdEstoque = dto.qtdEstoque();
        this.qtdAlertaEstoque = dto.qtdAlertaEstoque();
        this.linkyoutube = dto.linkyoutube();
        this.alertaQtdEstoque = dto.alertaQtdEstoque();
        this.qtdClique = dto.qtdClique();
        this.ativo = dto.ativo();
    }


    public Long getId() {
        return id;
    }

    public Produto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public Produto setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Double getPeso() {
        return peso;
    }

    public Produto setPeso(Double peso) {
        this.peso = peso;
        return this;
    }

    public Double getLargura() {
        return largura;
    }

    public Produto setLargura(Double largura) {
        this.largura = largura;
        return this;
    }

    public Double getAltura() {
        return altura;
    }

    public Produto setAltura(Double altura) {
        this.altura = altura;
        return this;
    }

    public Double getProfundidade() {
        return profundidade;
    }

    public Produto setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
        return this;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public Produto setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
        return this;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public Produto setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
        return this;
    }

    public String getLinkyoutube() {
        return linkyoutube;
    }

    public Produto setLinkyoutube(String linkyoutube) {
        this.linkyoutube = linkyoutube;
        return this;
    }

    public Boolean getAlertaQtdEstoque() {
        return alertaQtdEstoque;
    }

    public Produto setAlertaQtdEstoque(Boolean alertaQtdEstoque) {
        this.alertaQtdEstoque = alertaQtdEstoque;
        return this;
    }

    public Integer getQtdAlertaEstoque() {
        return qtdAlertaEstoque;
    }

    public Produto setQtdAlertaEstoque(Integer qtdAlertaEstoque) {
        this.qtdAlertaEstoque = qtdAlertaEstoque;
        return this;
    }

    public Integer getQtdClique() {
        return qtdClique;
    }

    public Produto setQtdClique(Integer qtdClique) {
        this.qtdClique = qtdClique;
        return this;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Produto setAtivo(Boolean ativo) {
        this.ativo = ativo;
        return this;
    }

    public PessoaJuridica getEmpresa() {
        return empresa;
    }

    public Produto setEmpresa(PessoaJuridica empresa) {
        this.empresa = empresa;
        return this;
    }

    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public Produto setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
        return this;
    }

    public MarcaProduto getMarcaProduto() {
        return marcaProduto;
    }

    public Produto setMarcaProduto(MarcaProduto marcaProduto) {
        this.marcaProduto = marcaProduto;
        return this;
    }



    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Produto produto = (Produto) object;
        return Objects.equals(getId(), produto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
