package br.com.altacommerce.service;

import br.com.altacommerce.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailAsyncService emailAsyncService;

    @Value("${app.url}")
    private String urlSite;

    public EmailService(EmailAsyncService emailAsyncService) {
        this.emailAsyncService = emailAsyncService;
    }

    public void enviarEmailVerificacao(Usuario usuario, String senhaEmTexto) {

        String assunto = "Bem-vindo ao Altacommerce — dados de acesso";

        String conteudo = gerarConteudoEmail(
                """
                <div style="font-family: Arial, Helvetica, sans-serif; background-color:#f4f6f8; padding:20px;">
                    <div style="max-width:600px; margin:auto; background:#ffffff; border-radius:8px; overflow:hidden;">
                        
                        <div style="background:#0d6efd; padding:20px; text-align:center;">
                            <h1 style="color:#ffffff; margin:0;">Altacommerce</h1>
                        </div>
    
                        <div style="padding:30px; color:#333333;">
                            <p>Olá <strong>[[name]]</strong>,</p>
    
                            <p>
                                Sua conta no <strong>Altacommerce</strong> foi criada com sucesso.
                                Abaixo estão seus dados de acesso:
                            </p>
    
                            <div style="background:#f1f3f5; padding:15px; border-radius:6px;">
                                <p><strong>Usuário:</strong> [[email]]</p>
                                <p><strong>Senha:</strong> [[senha]]</p>
                            </div>
    
                            <p style="margin-top:20px;">
                                Recomendamos que você altere sua senha após o primeiro login.
                            </p>
    
                            <div style="text-align:center; margin:30px 0;">
                                <a href="[[URL]]"
                                   style="
                                       background:#0d6efd;
                                       color:#ffffff;
                                       padding:14px 28px;
                                       text-decoration:none;
                                       border-radius:6px;
                                       font-weight:bold;
                                       display:inline-block;
                                   ">
                                    ACESSAR ALTACOMMERCE
                                </a>
                            </div>
    
                            <p>
                                Atenciosamente,<br>
                                <strong>Equipe Altacommerce</strong>
                            </p>
                        </div>
    
                    </div>
                </div>
                """,
                usuario.getUsername(),
                urlSite,
                usuario.getLogin(),
                senhaEmTexto
        );

        emailAsyncService.enviarEmail(usuario.getLogin(), assunto, conteudo);
    }

    public void enviarEmailTrocaSenha(Usuario usuario) {

        String assunto = "Sua senha expirou — ação necessária";

        String conteudo = gerarConteudoEmailTrocaSenha(
                """
                <div style="font-family: Arial, Helvetica, sans-serif; background-color:#f4f6f8; padding:20px;">
                    <div style="max-width:600px; margin:auto; background:#ffffff; border-radius:8px; overflow:hidden;">
                        
                        <div style="background:#dc3545; padding:20px; text-align:center;">
                            <h1 style="color:#ffffff; margin:0;">Altacommerce</h1>
                        </div>
    
                        <div style="padding:30px; color:#333333;">
                            <p>Olá <strong>[[name]]</strong>,</p>
    
                            <p>
                                Sua senha está expirada por motivos de segurança.
                            </p>
    
                            <p>
                                Para continuar utilizando o sistema, é necessário realizar a troca da senha.
                            </p>
    
                            <div style="text-align:center; margin:30px 0;">
                                <a href="[[URL]]/trocar-senha"
                                   style="
                                       background:#dc3545;
                                       color:#ffffff;
                                       padding:14px 28px;
                                       text-decoration:none;
                                       border-radius:6px;
                                       font-weight:bold;
                                       display:inline-block;
                                   ">
                                    TROCAR SENHA
                                </a>
                            </div>
    
                            <p style="margin-top:20px;">
                                Caso não reconheça esta solicitação, entre em contato com o suporte.
                            </p>
    
                            <p>
                                Atenciosamente,<br>
                                <strong>Equipe Altacommerce</strong>
                            </p>
                        </div>
    
                    </div>
                </div>
                """,
                usuario.getUsername(),
                urlSite
        );

        emailAsyncService.enviarEmail(
                usuario.getLogin(), // email
                assunto,
                conteudo
        );
    }

    private String gerarConteudoEmailTrocaSenha(
            String template,
            String nome,
            String url
    ) {
        return template
                .replace("[[name]]", nome)
                .replace("[[URL]]", url);
    }




    private String gerarConteudoEmail(
            String template,
            String nome,
            String url,
            String email,
            String senha
    ) {
        return template
                .replace("[[name]]", nome)
                .replace("[[URL]]", url)
                .replace("[[email]]", email)
                .replace("[[senha]]", senha);
    }

}
