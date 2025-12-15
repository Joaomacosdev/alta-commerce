package br.com.altacommerce.repository;

import br.com.altacommerce.model.Acesso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcessoRepository extends JpaRepository<Acesso, Long> {

    Page<Acesso> findByDescricaoContainingIgnoreCase(String descricao, Pageable pageable);

    Boolean existsByDescricao(String desc);

    Optional<Acesso> findByDescricao(String roleUser);
}
