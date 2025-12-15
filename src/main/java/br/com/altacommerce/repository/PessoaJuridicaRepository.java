package br.com.altacommerce.repository;

import br.com.altacommerce.model.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

    Boolean existsByCnpj(String cnpj);

    Boolean existsByEmail(String email);
}
