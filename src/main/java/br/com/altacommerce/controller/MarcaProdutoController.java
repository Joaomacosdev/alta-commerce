package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.MarcaProdutoRequestDTO;
import br.com.altacommerce.dto.response.MarcaProdutoResponseDTO;
import br.com.altacommerce.service.MarcaProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/v1/marca-produto")
public class MarcaProdutoController {

    private final MarcaProdutoService marcaProdutoService;

    public MarcaProdutoController(MarcaProdutoService marcaProdutoService) {
        this.marcaProdutoService = marcaProdutoService;
    }


    @PostMapping
    public ResponseEntity<MarcaProdutoResponseDTO> createProduto(@Valid @RequestBody MarcaProdutoRequestDTO dto, UriComponentsBuilder uriBuilder){
        MarcaProdutoResponseDTO marcaProduto = marcaProdutoService.createProduto(dto);
        URI uri = uriBuilder.path("api/v1/marca-produto/{id}").buildAndExpand(marcaProduto.id()).toUri();
        return ResponseEntity.created(uri).body(marcaProduto);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MarcaProdutoResponseDTO> getByIdMarcaProduto(@PathVariable Long id){
        return ResponseEntity.ok().body(marcaProdutoService.getByIdMarcaProduto(id));
    }

    @GetMapping("/nomeDesc/{nomeDesc}")
    public ResponseEntity<Page<MarcaProdutoResponseDTO>> getAllMarcaProduto(@PathVariable String nomeDesc, Pageable pageable){
        return ResponseEntity.ok().body(marcaProdutoService.getAllMarcaProdutoNome(nomeDesc, pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarcaProduto(@PathVariable Long id){
        marcaProdutoService.deleteMarcaProduto(id);
        return ResponseEntity.noContent().build();
    }

}
