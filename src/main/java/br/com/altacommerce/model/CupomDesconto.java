package br.com.altacommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cup_desc")
public class CupomDesconto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false)
    private String codDesc;
    private BigDecimal valorRealDesc;
    private BigDecimal valorPorcentDesc;

    private Date dataValidade;

    public CupomDesconto() {
    }

    public CupomDesconto(Long id, String codDesc, BigDecimal valorRealDesc, BigDecimal valorPorcentDesc, Date dataValidade) {
        this.id = id;
        this.codDesc = codDesc;
        this.valorRealDesc = valorRealDesc;
        this.valorPorcentDesc = valorPorcentDesc;
        this.dataValidade = dataValidade;
    }

    public Long getId() {
        return id;
    }

    public CupomDesconto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCodDesc() {
        return codDesc;
    }

    public CupomDesconto setCodDesc(String codDesc) {
        this.codDesc = codDesc;
        return this;
    }

    public BigDecimal getValorRealDesc() {
        return valorRealDesc;
    }

    public CupomDesconto setValorRealDesc(BigDecimal valorRealDesc) {
        this.valorRealDesc = valorRealDesc;
        return this;
    }

    public BigDecimal getValorPorcentDesc() {
        return valorPorcentDesc;
    }

    public CupomDesconto setValorPorcentDesc(BigDecimal valorPorcentDesc) {
        this.valorPorcentDesc = valorPorcentDesc;
        return this;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public CupomDesconto setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CupomDesconto that = (CupomDesconto) object;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
