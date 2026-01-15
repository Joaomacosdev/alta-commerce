package br.com.altacommerce.repository;

import br.com.altacommerce.model.AvaliacaoProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoProdutoRepository extends JpaRepository<AvaliacaoProduto, Long> {
    Page<AvaliacaoProduto> findByNota(Integer nota, Pageable pageable);
    Page<AvaliacaoProduto> findByDescricaoContainingIgnoreCase(String descricao, Pageable pageable);
}
