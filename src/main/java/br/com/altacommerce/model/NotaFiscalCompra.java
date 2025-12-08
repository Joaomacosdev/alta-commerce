package br.com.altacommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "nota_fiscal_compra")
public class NotaFiscalCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String serieNota;
    private String descricaoObs;
    @Column(nullable = false)
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;
    @Column(nullable = false)
    private BigDecimal valorIcms;
    @Column(nullable = false)
    private Date dataCompra;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "conta_pagar_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "conta_pagar_fk"))
    private ContaPagar contaPagar;

    public NotaFiscalCompra() {
    }

    public NotaFiscalCompra(String serieNota, String descricaoObs, BigDecimal valorTotal, BigDecimal valorDesconto, BigDecimal valorIcms, Date dataCompra, Pessoa pessoa, ContaPagar contaPagar) {
        this.serieNota = serieNota;
        this.descricaoObs = descricaoObs;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.valorIcms = valorIcms;
        this.dataCompra = dataCompra;
        this.pessoa = pessoa;
        this.contaPagar = contaPagar;
    }

    public Long getId() {
        return id;
    }

    public NotaFiscalCompra setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSerieNota() {
        return serieNota;
    }

    public NotaFiscalCompra setSerieNota(String serieNota) {
        this.serieNota = serieNota;
        return this;
    }

    public String getDescricaoObs() {
        return descricaoObs;
    }

    public NotaFiscalCompra setDescricaoObs(String descricaoObs) {
        this.descricaoObs = descricaoObs;
        return this;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public NotaFiscalCompra setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public NotaFiscalCompra setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
        return this;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public NotaFiscalCompra setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
        return this;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public NotaFiscalCompra setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
        return this;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public NotaFiscalCompra setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        return this;
    }

    public ContaPagar getContaPagar() {
        return contaPagar;
    }

    public NotaFiscalCompra setContaPagar(ContaPagar contaPagar) {
        this.contaPagar = contaPagar;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        NotaFiscalCompra that = (NotaFiscalCompra) object;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
