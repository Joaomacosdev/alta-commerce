package br.com.altacommerce.model;

import br.com.altacommerce.dto.request.AcessoRequestDTO;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity
@Table(name = "acesso")
public class Acesso implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descricao", nullable = false, unique = true)
    private String descricao; // exemplo: ROLE_ADMIN, ROLE_USER

    public Acesso() {
    }

    public Acesso(AcessoRequestDTO dto) {
        this.descricao = dto.descricao();
    }

    public Long getId() {
        return id;
    }


    @Override
    public  String getAuthority() {
        return this.descricao;
    }


    public Acesso setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Acesso setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Acesso acesso = (Acesso) object;
        return Objects.equals(getId(), acesso.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }


}
