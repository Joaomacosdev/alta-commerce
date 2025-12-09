package br.com.altacommerce.repository;

import br.com.altacommerce.model.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcessoRepository extends JpaRepository<Acesso, Long> {

    List<Acesso> findByDescricaoContainingIgnoreCase(String descricao);

}
