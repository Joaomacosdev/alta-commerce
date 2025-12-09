package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.AcessoRequestDTO;
import br.com.altacommerce.dto.response.AcessoResponseDTO;
import br.com.altacommerce.service.AcessoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1/acesso")
public class AcessoController {

    private final AcessoService acessoService;

    public AcessoController(AcessoService acessoService) {
        this.acessoService = acessoService;
    }

    @PostMapping
    public ResponseEntity<AcessoResponseDTO> createAcesso(@RequestBody AcessoRequestDTO dto, UriComponentsBuilder uriBuilder){
        AcessoResponseDTO acesso = acessoService.createAcesso(dto);
        URI uri = uriBuilder.path("api/v1/acesso/{id}").buildAndExpand(acesso.id()).toUri();
        return ResponseEntity.created(uri).body(acesso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcesso(@PathVariable Long id){
        acessoService.deleteAcesso(id);
        return ResponseEntity.noContent().build();
    }
}
