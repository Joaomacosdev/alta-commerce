package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.AvaliacaoProdutoRequestDTO;
import br.com.altacommerce.dto.response.AvaliacaoProdutoResponseDTO;
import br.com.altacommerce.service.AvaliacaoProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/v1/avaliacao-produto")
public class AvaliacaoProdutoController {

    private final AvaliacaoProdutoService avaliacaoProdutoService;

    public AvaliacaoProdutoController(AvaliacaoProdutoService avaliacaoProdutoService) {
        this.avaliacaoProdutoService = avaliacaoProdutoService;
    }

    @PostMapping
    public ResponseEntity<AvaliacaoProdutoResponseDTO> createAvaliacaoProduto(@Valid @RequestBody AvaliacaoProdutoRequestDTO dto, UriComponentsBuilder uriBuilder){
        AvaliacaoProdutoResponseDTO avaliacaoProduto = avaliacaoProdutoService.createAvaliacaoProduto(dto);
        URI uri = uriBuilder.path("api/v1/avaliacao-produto/{id}").buildAndExpand(avaliacaoProduto.id()).toUri();
        return ResponseEntity.created(uri).body(avaliacaoProduto);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<AvaliacaoProdutoResponseDTO> getByIdAvalicaoProduto(@PathVariable Long id){
        return ResponseEntity.ok().body(avaliacaoProdutoService.getByIdAvalicaoProduto(id));
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<Page<AvaliacaoProdutoResponseDTO>> getAllAvaliacaoProdutoDescricao(@PathVariable String descricao, Pageable pageable){
        return ResponseEntity.ok().body(avaliacaoProdutoService.getAllAvalaicaoProdutoDescricao(descricao, pageable));
    }

    @GetMapping("/nota/{nota}")
    public ResponseEntity<Page<AvaliacaoProdutoResponseDTO>> getAllAvaliacaoProdutoNota(@PathVariable Integer nota, Pageable pageable){
        return ResponseEntity.ok().body(avaliacaoProdutoService.getAllAvalaicaoProdutoNota(nota, pageable));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> getAllAvaliacaoProdutoNota(@PathVariable Long id){
        avaliacaoProdutoService.deleteAvaliacaoProduto(id);
        return ResponseEntity.noContent().build();
    }
}
