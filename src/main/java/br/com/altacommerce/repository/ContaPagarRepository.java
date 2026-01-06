package br.com.altacommerce.repository;

import br.com.altacommerce.model.ContaPagar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaPagarRepository extends JpaRepository<ContaPagar, Long> {
  Page<ContaPagar> findByDescricaoContainingIgnoreCase(String descricao, Pageable pageable);
  Page<ContaPagar> findByPessoaId(Long pessoaId, Pageable pageable);

}
