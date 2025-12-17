package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.Acesso;
import br.com.altacommerce.model.PessoaJuridica;
import br.com.altacommerce.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Set;

public record UsuarioResponseDTO(
        Long id,
        String login,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate dataAtualSenha,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate dataUltimaNotificacaoSenha,
        Set<Acesso> acessos,
        PessoaJuridica empresa
) {
    public UsuarioResponseDTO(Usuario usuarios) {
        this(usuarios.getId(), usuarios.getLogin(), usuarios.getDataAtualSenha(),
                usuarios.getDataUltimaNotificacaoSenha(), usuarios.getAcessos(), usuarios.getEmpresa());
    }
}
