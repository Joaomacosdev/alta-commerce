package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.AcessoDeleteRequestDTO;
import br.com.altacommerce.dto.request.AcessoRequestDTO;
import br.com.altacommerce.dto.response.AcessoResponseDTO;
import br.com.altacommerce.service.AcessoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/id/{id}")
    public ResponseEntity<AcessoResponseDTO> getAcessoById(@PathVariable Long id){
        return ResponseEntity.ok().body(acessoService.getAcessoById(id));
    }

    @GetMapping("/desc/{desc}")
    public ResponseEntity<Page<AcessoResponseDTO>> getAllAcesso(@PathVariable String desc, Pageable pageable){
        var acesso = acessoService.getAllAcesso(desc, pageable);
        return ResponseEntity.ok().body(acesso);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAcesso(@RequestBody AcessoDeleteRequestDTO dto){
        acessoService.deleteAcessoPorID(dto.id());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcessoPorId(@PathVariable Long id){
        acessoService.deleteAcessoPorID(id);
        return ResponseEntity.noContent().build();
    }
}
