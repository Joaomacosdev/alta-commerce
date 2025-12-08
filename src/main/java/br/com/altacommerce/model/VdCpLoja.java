package br.com.altacommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "vd_cp_loja")
public class VdCpLoja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey =
    @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id", nullable = false, foreignKey =
    @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_entrega_fk"))
    private Endereco enderecoEntrega;

    @ManyToOne
    @JoinColumn(name = "enderco_cobranca_id", nullable = false, foreignKey =
    @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "enderco_cobranca_fk"))
    private Endereco endercoCobranca;

    @Column(nullable = false)
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id", nullable = false, foreignKey =
    @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "forma_pagamento_fk"))
    private FormaPagamento formaPagamento;

    @OneToOne
    @JoinColumn(name = "nota_fiscal_venda_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "nota_fiscal_venda_fk"))
    private NotaFiscalvenda notaFiscalvenda;

    @ManyToOne
    @JoinColumn(name = "cupom_desconto_id", nullable = true,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "cupom_desconto_fk"))
    private CupomDesconto cupomDesconto;

    @Column(nullable = false)
    private BigDecimal valorFrete;
    @Column(nullable = false)
    private Integer diasEntrega;

    @Column(nullable = false)
    private Date dataVenda;
    @Column(nullable = false)
    private Date dataEntrega;

    public VdCpLoja() {
    }

    public VdCpLoja(Pessoa pessoa, Endereco enderecoEntrega, Endereco endercoCobranca, BigDecimal valorTotal, BigDecimal valorDesconto, FormaPagamento formaPagamento, NotaFiscalvenda notaFiscalvenda, CupomDesconto cupomDesconto, BigDecimal valorFrete, Integer diasEntrega, Date dataVenda, Date dataEntrega) {
        this.pessoa = pessoa;
        this.enderecoEntrega = enderecoEntrega;
        this.endercoCobranca = endercoCobranca;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.formaPagamento = formaPagamento;
        this.notaFiscalvenda = notaFiscalvenda;
        this.cupomDesconto = cupomDesconto;
        this.valorFrete = valorFrete;
        this.diasEntrega = diasEntrega;
        this.dataVenda = dataVenda;
        this.dataEntrega = dataEntrega;
    }

    public Long getId() {
        return id;
    }

    public VdCpLoja setId(Long id) {
        this.id = id;
        return this;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public VdCpLoja setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        return this;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public VdCpLoja setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
        return this;
    }

    public Endereco getEndercoCobranca() {
        return endercoCobranca;
    }

    public VdCpLoja setEndercoCobranca(Endereco endercoCobranca) {
        this.endercoCobranca = endercoCobranca;
        return this;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public VdCpLoja setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public VdCpLoja setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
        return this;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public VdCpLoja setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
        return this;
    }

    public NotaFiscalvenda getNotaFiscalvenda() {
        return notaFiscalvenda;
    }

    public VdCpLoja setNotaFiscalvenda(NotaFiscalvenda notaFiscalvenda) {
        this.notaFiscalvenda = notaFiscalvenda;
        return this;
    }

    public CupomDesconto getCupomDesconto() {
        return cupomDesconto;
    }

    public VdCpLoja setCupomDesconto(CupomDesconto cupomDesconto) {
        this.cupomDesconto = cupomDesconto;
        return this;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public VdCpLoja setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
        return this;
    }

    public Integer getDiasEntrega() {
        return diasEntrega;
    }

    public VdCpLoja setDiasEntrega(Integer diasEntrega) {
        this.diasEntrega = diasEntrega;
        return this;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public VdCpLoja setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
        return this;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public VdCpLoja setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        VdCpLoja vdCpLoja = (VdCpLoja) object;
        return Objects.equals(getId(), vdCpLoja.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
