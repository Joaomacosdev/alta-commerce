package br.com.altacommerce.controller;

import br.com.altacommerce.model.Acesso;
import br.com.altacommerce.service.AcessoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

    private final AcessoService acessoService;

    public AcessoController(AcessoService acessoService) {
        this.acessoService = acessoService;
    }

    @PostMapping
    public Acesso createAcesso(Acesso acesso){
        return acessoService.createAcesso(acesso);
    }
}
