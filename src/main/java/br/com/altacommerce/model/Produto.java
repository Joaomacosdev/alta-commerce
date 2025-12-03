package br.com.altacommerce.model;

import jakarta.persistence.*;
import org.hibernate.sql.ast.tree.expression.JsonTableColumnDefinition;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoUnidade;
    private String nome;
    @Column(columnDefinition = "TEXT", length = 2000)
    private String descricao;
    private Double peso;
    private Double largura;
    private Double altura;
    private Double profundidade;
    private BigDecimal valorVenda;
    private Integer qtdEstoque;
    private String linkyoutube;
    private Boolean alertaQtdEstoque;
    private Integer qtdClique;
    private Boolean ativo = true;

    public Produto() {
    }

    public Produto(Long id, String tipoUnidade, String nome, String descricao, Double peso, Double largura, Double altura, Double profundidade, BigDecimal valorVenda, Integer qtdEstoque, String linkyoutube, Boolean alertaQtdEstoque, Integer qtdClique) {
        this.id = id;
        this.tipoUnidade = tipoUnidade;
        this.nome = nome;
        this.descricao = descricao;
        this.peso = peso;
        this.largura = largura;
        this.altura = altura;
        this.profundidade = profundidade;
        this.valorVenda = valorVenda;
        this.qtdEstoque = qtdEstoque;
        this.linkyoutube = linkyoutube;
        this.alertaQtdEstoque = alertaQtdEstoque;
        this.qtdClique = qtdClique;
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
