package br.com.altacommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "nota_fiscal_venda")
public class NotaFiscalvenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String serie;

    private String tipo;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String xml;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String pdf;

    @OneToOne
    @JoinColumn(name = "vd_cp_loja_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "vd_cp_loja_id_fk"))
    private VdCpLoja vdCpLoja;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_fk"))
    private PessoaJuridica empresa;

    public NotaFiscalvenda() {
    }



    public Long getId() {
        return id;
    }

    public NotaFiscalvenda setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public NotaFiscalvenda setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getSerie() {
        return serie;
    }

    public NotaFiscalvenda setSerie(String serie) {
        this.serie = serie;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public NotaFiscalvenda setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getXml() {
        return xml;
    }

    public NotaFiscalvenda setXml(String xml) {
        this.xml = xml;
        return this;
    }

    public String getPdf() {
        return pdf;
    }

    public NotaFiscalvenda setPdf(String pdf) {
        this.pdf = pdf;
        return this;
    }

    public VdCpLoja getVdCpLoja() {
        return vdCpLoja;
    }

    public NotaFiscalvenda setVdCpLoja(VdCpLoja vdCpLoja) {
        this.vdCpLoja = vdCpLoja;
        return this;
    }

    public PessoaJuridica getEmpresa() {
        return empresa;
    }

    public NotaFiscalvenda setEmpresa(PessoaJuridica empresa) {
        this.empresa = empresa;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        NotaFiscalvenda that = (NotaFiscalvenda) object;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
