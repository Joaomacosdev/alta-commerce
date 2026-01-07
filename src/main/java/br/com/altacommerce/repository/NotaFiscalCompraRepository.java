package br.com.altacommerce.repository;

import br.com.altacommerce.model.NotaFiscalCompra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaFiscalCompraRepository extends JpaRepository<NotaFiscalCompra, Long> {
    Page<NotaFiscalCompra> findByDescricaoObsContainingIgnoreCase(String descricao, Pageable pageable);

    Page<NotaFiscalCompra> findByPessoaId(Long pessoaId, Pageable pageable);
}
