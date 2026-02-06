package br.com.altacommerce.model;

import br.com.altacommerce.dto.request.VdCpLojaRequestDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vd_cp_loja")
public class VdCpLoja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valorFrete;
    @Column(nullable = false)
    private Integer diasEntrega;

    @Column(nullable = false)
    private LocalDate dataVenda;
    @Column(nullable = false)
    private LocalDate dataEntrega;
    @Column(nullable = false)
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;

    @ManyToOne()
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey =
    @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id", nullable = false, foreignKey =
    @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_entrega_fk"))
    private Endereco enderecoEntrega;

    @ManyToOne()
    @JoinColumn(name = "enderco_cobranca_id", nullable = false, foreignKey =
    @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "enderco_cobranca_fk"))
    private Endereco endercoCobranca;

    @ManyToOne()
    @JoinColumn(name = "forma_pagamento_id", nullable = false, foreignKey =
    @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "forma_pagamento_fk"))
    private FormaPagamento formaPagamento;

    @OneToOne( cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "nota_fiscal_venda_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "nota_fiscal_venda_fk"))
    private NotaFiscalvenda notaFiscalvenda;

    @ManyToOne
    @JoinColumn(name = "cupom_desconto_id", nullable = true,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "cupom_desconto_fk"))
    private CupomDesconto cupomDesconto;


    @ManyToOne()
    @JoinColumn(name = "empresa_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_fk"))
    private PessoaJuridica empresa;

    @OneToMany(mappedBy = "vdCpLoja", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemVendaLoja> itemVendaLojas = new ArrayList<>();

    @OneToMany(mappedBy = "vdCpLoja", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StatusRastreio> statusRastreios = new ArrayList<>();

    private String codigoEtiqueta;

    private String urlImprimiEtiqueta;

    private Integer servicoTransportadora;

    public VdCpLoja() {
    }


    public VdCpLoja(VdCpLojaRequestDTO dto) {
        this.valorFrete = dto.valorFrete();
        this.diasEntrega = dto.diasEntrega();
        this.dataEntrega = dto.dataEntrega();
        this.valorTotal = dto.valorTotal();
        this.valorDesconto = dto.valorDesconto();
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

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public VdCpLoja setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
        return this;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public VdCpLoja setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
        return this;
    }

    public PessoaJuridica getEmpresa() {
        return empresa;
    }

    public VdCpLoja setEmpresa(PessoaJuridica empresa) {
        this.empresa = empresa;
        return this;
    }

    public List<ItemVendaLoja> getItemVendaLojas() {
        return itemVendaLojas;
    }

    public VdCpLoja setItemVendaLojas(List<ItemVendaLoja> itemVendaLojas) {
        this.itemVendaLojas = itemVendaLojas;
        return this;
    }

    public List<StatusRastreio> getStatusRastreios() {
        return statusRastreios;
    }

    public VdCpLoja setStatusRastreios(List<StatusRastreio> statusRastreios) {
        this.statusRastreios = statusRastreios;
        return this;
    }

    public void adicionarStatus(StatusRastreio status){
        this.statusRastreios.add(status);
        status.setVdCpLoja(this);
    }

    public void adicionarItem(ItemVendaLoja item) {
        this.itemVendaLojas.add(item);
        item.setVdCpLoja(this);
    }

    public String getCodigoEtiqueta() {
        return codigoEtiqueta;
    }

    public VdCpLoja setCodigoEtiqueta(String codigoEtiqueta) {
        this.codigoEtiqueta = codigoEtiqueta;
        return this;
    }

    public String getUrlImprimiEtiqueta() {
        return urlImprimiEtiqueta;
    }

    public VdCpLoja setUrlImprimiEtiqueta(String urlImprimiEtiqueta) {
        this.urlImprimiEtiqueta = urlImprimiEtiqueta;
        return this;
    }

    public Integer getServicoTransportadora() {
        return servicoTransportadora;
    }

    public VdCpLoja setServicoTransportadora(Integer servicoTransportadora) {
        this.servicoTransportadora = servicoTransportadora;
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
