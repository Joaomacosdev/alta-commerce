package br.com.altacommerce.model;

import br.com.altacommerce.model.enums.StatusContaReceber;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "conta_receber")
public class ContaReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Date dtVencimento;
    private Date dtPagamento;
    @Column(nullable = false)
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;
    @ManyToOne
    @JoinColumn(
            name = "pessoa_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "pessoa_fk")
    )
    private Pessoa pessoa;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusContaReceber status;

    public ContaReceber() {
    }

    public ContaReceber(Long id, String descricao, Date dtVencimento, Date dtPagamento, BigDecimal valorTotal, BigDecimal valorDesconto, Pessoa pessoa, StatusContaReceber status) {
        this.id = id;
        this.descricao = descricao;
        this.dtVencimento = dtVencimento;
        this.dtPagamento = dtPagamento;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.pessoa = pessoa;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public ContaReceber setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public ContaReceber setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public ContaReceber setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
        return this;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public ContaReceber setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
        return this;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public ContaReceber setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public ContaReceber setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
        return this;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public ContaReceber setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        return this;
    }

    public StatusContaReceber getStatus() {
        return status;
    }

    public ContaReceber setStatus(StatusContaReceber status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ContaReceber endereco = (ContaReceber) object;
        return Objects.equals(getId(), endereco.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
