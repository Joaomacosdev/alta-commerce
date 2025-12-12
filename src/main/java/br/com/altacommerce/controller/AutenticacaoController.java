package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.DadosLoginDTO;
import br.com.altacommerce.infra.security.DadosTokenJWT;
import br.com.altacommerce.infra.security.TokenService;
import br.com.altacommerce.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/login")
public class AutenticacaoController {


    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin( @RequestBody DadosLoginDTO dados){
        var autenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = authenticationManager.authenticate(autenticationToken);
        String tokenAcesso = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok().body(new DadosTokenJWT(tokenAcesso));
    }
}
