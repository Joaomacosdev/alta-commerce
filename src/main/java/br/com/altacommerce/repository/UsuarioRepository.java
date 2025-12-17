package br.com.altacommerce.repository;

import br.com.altacommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("""
        SELECT u FROM Usuario u
        WHERE u.dataAtualSenha <= :dataLimite
    """)
    List<Usuario> buscarUsuariosComSenhaExpirada(
            @Param("dataLimite") LocalDate dataLimite
    );

    Optional<Usuario> findByLogin(String login);

    Optional<Usuario> findByPessoaId(Long id);
}
