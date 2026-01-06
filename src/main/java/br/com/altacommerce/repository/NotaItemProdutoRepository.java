package br.com.altacommerce.repository;

import br.com.altacommerce.model.MarcaProduto;
import br.com.altacommerce.model.NotaItemProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaItemProdutoRepository extends JpaRepository<NotaItemProduto, Long> {
}
