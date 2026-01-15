package br.com.altacommerce.repository;

import br.com.altacommerce.model.ImagemProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemProdutoRepository extends JpaRepository<ImagemProduto, Long> {

    Page<ImagemProduto> findAllById(Long id, Pageable pageable);

}
