package br.com.altacommerce.repository;

import br.com.altacommerce.model.CategoriaProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {

    Boolean existsByNomeDescIgnoreCaseAndEmpresaId(String nomeDesc, Long empresaId);

}
