package br.com.altacommerce.scheduler;

import br.com.altacommerce.service.UsuarioService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TrocaSenhaScheduler {

    private final UsuarioService usuarioService;

    public TrocaSenhaScheduler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @Scheduled(cron = "0 30 20 * * ?", zone = "America/Sao_Paulo")
    public void notificarUserTrocarSenha() {

        var usuarios = usuarioService.buscarUsuariosComSenhaVencida();

        if (usuarios.isEmpty()) {
            return;
        }

        usuarios.forEach(usuario -> {
            try {
                usuarioService.notificarTrocaSenha(usuario);
            } catch (Exception e) {
                // exceção ignorada para não interromper o job
            }
        });
    }

}
