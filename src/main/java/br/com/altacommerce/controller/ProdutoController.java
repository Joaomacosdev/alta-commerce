package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.ProdutoRequestDTO;
import br.com.altacommerce.dto.response.ProdutoResponseDTO;
import br.com.altacommerce.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/v1/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> createProduto(@Valid @RequestBody ProdutoRequestDTO dto, UriComponentsBuilder uriBuilder){
        ProdutoResponseDTO produtoResponse = produtoService.createProduto(dto);
        URI uri = uriBuilder.path("api/v1/produto/{id}").buildAndExpand(produtoResponse.id()).toUri();
        return ResponseEntity.created(uri).body(produtoResponse);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProdutoResponseDTO> getByProdutoId(@PathVariable Long id){
        return ResponseEntity.ok().body(produtoService.getByProdutoId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Page<ProdutoResponseDTO>> getAllProdutoNome(@PathVariable String nome, Pageable pageable){
        return ResponseEntity.ok().body(produtoService.getAllProdutoNome(nome, pageable));
    }

    @GetMapping("/desc/{descricao}")
    public ResponseEntity<Page<ProdutoResponseDTO>> getAllProdutoDescricao(@PathVariable String descricao, Pageable pageable){
        return ResponseEntity.ok().body(produtoService.getAllProdutoDescricao(descricao, pageable));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id){
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}
