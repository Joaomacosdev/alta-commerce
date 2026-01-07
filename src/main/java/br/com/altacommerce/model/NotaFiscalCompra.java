package br.com.altacommerce.model;

import br.com.altacommerce.dto.request.NotaFiscalCompraRequestDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    private BigDecimal valorFinal;
    @Column(nullable = false)
    private LocalDate dataCompra;



    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "conta_pagar_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "conta_pagar_fk"))
    private ContaPagar contaPagar;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_fk"))
    private PessoaJuridica empresa;


    @OneToMany(
            mappedBy = "notaFiscalCompra",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<NotaItemProduto> itens = new ArrayList<>();

    public NotaFiscalCompra() {
    }

    public NotaFiscalCompra(NotaFiscalCompraRequestDTO dto) {
        this.serieNota = dto.serieNota();
        this.descricaoObs = dto.descricaoObs();
        this.valorTotal = dto.valorTotal();
        this.valorDesconto = dto.valorDesconto();
        this.valorIcms = dto.valorIcms();
    }

    public void calcularValorFinal() {
        BigDecimal total = Optional.ofNullable(valorTotal).orElse(BigDecimal.ZERO);
        BigDecimal icms = Optional.ofNullable(valorIcms).orElse(BigDecimal.ZERO);
        BigDecimal desconto = Optional.ofNullable(valorDesconto).orElse(BigDecimal.ZERO);

        this.valorFinal = total
                .add(icms)
                .subtract(desconto);
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

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public NotaFiscalCompra setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
        return this;
    }

    public NotaFiscalCompra setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
        return this;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public NotaFiscalCompra setDataCompra(LocalDate dataCompra) {
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

    public PessoaJuridica getEmpresa() {
        return empresa;
    }

    public NotaFiscalCompra setEmpresa(PessoaJuridica empresa) {
        this.empresa = empresa;
        return this;
    }

    public List<NotaItemProduto> getItens() {
        return itens;
    }

    public void adicionarItem(NotaItemProduto item) {
        itens.add(item);
        item.setNotaFiscalCompra(this);
    }

    public void removerItem(NotaItemProduto item) {
        itens.remove(item);
        item.setNotaFiscalCompra(null);
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
