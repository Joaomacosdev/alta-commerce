package br.com.altacommerce.repository;

import br.com.altacommerce.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
    Boolean existsByCpf(String cpf);


    Boolean existsByEmail(String email);

}
