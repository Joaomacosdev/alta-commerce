package br.com.altacommerce.repository;

import br.com.altacommerce.model.VdCpLoja;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface VdCpLojaRepository extends JpaRepository<VdCpLoja, Long> {

    @Query("""
    SELECT DISTINCT v
    FROM VdCpLoja v
    JOIN v.itemVendaLojas i
    JOIN i.produto p
    WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))
""")
    Page<VdCpLoja> buscarPorNomeProduto(
            @Param("nome") String nome,
            Pageable pageable
    );


    @Query("""
    SELECT v
    FROM VdCpLoja v
    JOIN v.pessoa p
    WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))
""")
    Page<VdCpLoja> buscarPorNomePessoa(
            @Param("nome") String nome,
            Pageable pageable
    );

    Page<VdCpLoja> findByDataVendaGreaterThanEqualAndDataVendaLessThanEqual(
            LocalDate inicio,
            LocalDate fim,
            Pageable pageable
    );

}
