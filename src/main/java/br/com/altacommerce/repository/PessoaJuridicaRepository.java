package br.com.altacommerce.repository;

import br.com.altacommerce.model.PessoaJuridica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

    Boolean existsByCnpj(String cnpj);

    Boolean existsByEmail(String email);

    Page<PessoaJuridica> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    Page<PessoaJuridica> findByCnpj(String cnpj, Pageable pageable);

    Optional< PessoaJuridica> findByCnpj(String cnpj);

}
