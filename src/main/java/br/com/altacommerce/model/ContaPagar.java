package br.com.altacommerce.model;

import br.com.altacommerce.model.enums.StatusContaPagar;
import br.com.altacommerce.model.enums.StatusContaReceber;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "conta_pagar")
public class ContaPagar {

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


    @ManyToOne
    @JoinColumn(
            name = "pessoa_forn_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "pessoa_forn_fk")
    )
    private Pessoa pessoaFornecedor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusContaPagar status;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_fk"))
    private PessoaJuridica empresa;

    public ContaPagar() {
    }



    public Long getId() {
        return id;
    }

    public ContaPagar setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public ContaPagar setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public ContaPagar setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
        return this;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public ContaPagar setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
        return this;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public ContaPagar setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public ContaPagar setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
        return this;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public ContaPagar setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        return this;
    }

    public StatusContaPagar getStatus() {
        return status;
    }

    public ContaPagar setStatus(StatusContaPagar status) {
        this.status = status;
        return this;
    }

    public Pessoa getPessoaFornecedor() {
        return pessoaFornecedor;
    }

    public ContaPagar setPessoaFornecedor(Pessoa pessoaFornecedor) {
        this.pessoaFornecedor = pessoaFornecedor;
        return this;
    }

    public PessoaJuridica getEmpresa() {
        return empresa;
    }

    public ContaPagar setEmpresa(PessoaJuridica empresa) {
        this.empresa = empresa;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ContaPagar endereco = (ContaPagar) object;
        return Objects.equals(getId(), endereco.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
