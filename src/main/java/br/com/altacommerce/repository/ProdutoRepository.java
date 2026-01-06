package br.com.altacommerce.repository;

import br.com.altacommerce.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Boolean existsByNome(String nome);
    Page<Produto> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    Page<Produto> findByDescricaoContainingIgnoreCase(String descricao, Pageable pageable);
}
