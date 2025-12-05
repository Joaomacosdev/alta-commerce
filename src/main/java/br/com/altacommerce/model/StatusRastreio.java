package br.com.altacommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "status_rastreio")
public class StatusRastreio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String centroDistribuicao;
    private String estado;
    private String status;

    @ManyToOne
    @JoinColumn(name = "vd_cp_loja_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "vd_cp_loja_fk"))
    private VdCpLoja vdCpLoja;

    public StatusRastreio() {
    }

    public StatusRastreio(Long id, String centroDistribuicao, String estado, String status, VdCpLoja vdCpLoja) {
        this.id = id;
        this.centroDistribuicao = centroDistribuicao;
        this.estado = estado;
        this.status = status;
        this.vdCpLoja = vdCpLoja;
    }

    public Long getId() {
        return id;
    }

    public StatusRastreio setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCentroDistribuicao() {
        return centroDistribuicao;
    }

    public StatusRastreio setCentroDistribuicao(String centroDistribuicao) {
        this.centroDistribuicao = centroDistribuicao;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public StatusRastreio setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public StatusRastreio setStatus(String status) {
        this.status = status;
        return this;
    }

    public VdCpLoja getVdCpLoja() {
        return vdCpLoja;
    }

    public StatusRastreio setVdCpLoja(VdCpLoja vdCpLoja) {
        this.vdCpLoja = vdCpLoja;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        StatusRastreio that = (StatusRastreio) object;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
