package br.com.altacommerce.controller;

import br.com.altacommerce.dto.auth.request.LoginRequestDTO;
import br.com.altacommerce.dto.auth.response.AuthResponseDTO;
import br.com.altacommerce.dto.auth.request.RefreshTokenRequestDTO;
import br.com.altacommerce.infra.security.TokenService;
import br.com.altacommerce.model.Usuario;
import br.com.altacommerce.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/login")
public class AutenticacaoController {


    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    public AutenticacaoController(AuthenticationManager authenticationManager, TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<AuthResponseDTO> efetuarLogin(@RequestBody LoginRequestDTO dados) {
        var autenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = authenticationManager.authenticate(autenticationToken);

        String tokenAcesso = tokenService.gerarToken((Usuario) Objects.requireNonNull(authentication.getPrincipal()));
        String refreshToken = tokenService.gerarRefreshToken((Usuario) Objects.requireNonNull(authentication.getPrincipal()));

        return ResponseEntity.ok().body(new AuthResponseDTO(tokenAcesso, refreshToken));
    }

    @PostMapping("/atualizar-token")
    public ResponseEntity<AuthResponseDTO> atualizarToken(@RequestBody RefreshTokenRequestDTO dados){
        var refreshToken = dados.refreshToken();
        Long idUsuario = Long.valueOf(tokenService.getSubject(refreshToken));
        var usuario = usuarioRepository.findById(idUsuario).orElseThrow();

        String tokenAcesso = tokenService.gerarToken(usuario);
        String tokenAtualizacao = tokenService.gerarRefreshToken(usuario);

        return ResponseEntity.ok().body(new AuthResponseDTO(tokenAcesso, tokenAtualizacao));
    }
}
