package br.com.altacommerce.repository;

import br.com.altacommerce.model.PessoaFisica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
    Boolean existsByCpf(String cpf);


    Boolean existsByEmail(String email);

    Page<PessoaFisica> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    Page<PessoaFisica> findByCpf(String cnpj, Pageable pageable);

    Optional<PessoaFisica> findByCpf(String cnpj);


}
