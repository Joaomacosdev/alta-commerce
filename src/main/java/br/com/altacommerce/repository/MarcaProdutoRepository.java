package br.com.altacommerce.repository;

import br.com.altacommerce.model.MarcaProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaProdutoRepository extends JpaRepository<MarcaProduto, Long> {
    Boolean existsByNomeDesc(String nomeDesc);
    Page<MarcaProduto> findByNomeDescContainingIgnoreCase(String nome, Pageable pageable);

}
