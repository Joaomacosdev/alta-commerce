package br.com.altacommerce.repository;

import br.com.altacommerce.model.MarcaProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaProdutoRepository extends JpaRepository<MarcaProduto, Long> {
}
