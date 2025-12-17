package br.com.altacommerce.service;

import br.com.altacommerce.dto.response.UsuarioResponseDTO;
import br.com.altacommerce.model.Usuario;
import br.com.altacommerce.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EmailService emailService;
    private static final int DIAS_EXPIRACAO_SENHA = 90;


    public UsuarioService(UsuarioRepository usuarioRepository, EmailService emailService) {
        this.usuarioRepository = usuarioRepository;
        this.emailService = emailService;
    }

    public List<Usuario> buscarUsuariosComSenhaVencida() {
        LocalDate limite = LocalDate.now().minusDays(DIAS_EXPIRACAO_SENHA);
        return usuarioRepository.buscarUsuariosComSenhaExpirada(limite);
    }

    public void notificarTrocaSenha(Usuario usuario) {
        LocalDate hoje = LocalDate.now();

        if (usuario.getDataUltimaNotificacaoSenha() != null &&
                !usuario.getDataUltimaNotificacaoSenha().isBefore(hoje.minusDays(90))) {
            return;
        }
        emailService.enviarEmailTrocaSenha(usuario);
        usuario.setDataUltimaNotificacaoSenha(hoje);
        usuarioRepository.save(usuario);
    }


}
