package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.CategoriaProdutoRequestDTO;
import br.com.altacommerce.dto.response.CategoriaProdutoResponseDTO;
import br.com.altacommerce.service.CategoriaProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/v1/categoria-produto")
public class CategoriaProdutoController {

    private final CategoriaProdutoService categoriaProdutoService;

    public CategoriaProdutoController(CategoriaProdutoService categoriaProdutoService) {
        this.categoriaProdutoService = categoriaProdutoService;
    }

    @PostMapping
    public ResponseEntity<CategoriaProdutoResponseDTO> createCategoriaProduto(@Valid @RequestBody CategoriaProdutoRequestDTO dto, UriComponentsBuilder uriBuilder){
        CategoriaProdutoResponseDTO categoriaProduto = categoriaProdutoService.creteCategoriaProduto(dto);
        URI uri = uriBuilder.path("api/v1/categoria-produto/{id}").buildAndExpand(categoriaProduto.id()).toUri();
        return ResponseEntity.created(uri).body(categoriaProduto);
    }
}
