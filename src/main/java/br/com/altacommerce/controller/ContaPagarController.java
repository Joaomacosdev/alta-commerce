package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.ContaPagarRequestDTO;
import br.com.altacommerce.dto.response.ContaPagarResponseDTO;
import br.com.altacommerce.service.ContaPagarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/v1/conta-pagar")
public class ContaPagarController {

    private final ContaPagarService contaPagarService;

    public ContaPagarController(ContaPagarService contaPagarService) {
        this.contaPagarService = contaPagarService;
    }

    @PostMapping
    public ResponseEntity<ContaPagarResponseDTO> createContaPagar(@Valid @RequestBody ContaPagarRequestDTO dto, UriComponentsBuilder uriBuilder) {
        ContaPagarResponseDTO contaPagar = contaPagarService.createContaPagar(dto);
        URI uri = uriBuilder.path("api/v1/conta-pagar/{id}").buildAndExpand(contaPagar.id()).toUri();
        return ResponseEntity.created(uri).body(contaPagar);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ContaPagarResponseDTO> getByIdContaPagar(@PathVariable Long id) {
        return ResponseEntity.ok().body(contaPagarService.getByIdContaPagar(id));
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<Page<ContaPagarResponseDTO>> getAllMarcaContaPagarDescricao(@PathVariable String descricao, Pageable pageable) {
        return ResponseEntity.ok().body(contaPagarService.getAllMarcaContaPagarDescricao(descricao, pageable));
    }

    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<Page<ContaPagarResponseDTO>> listarPorPessoa(@PathVariable Long pessoaId, Pageable pageable) {
        return ResponseEntity.ok(contaPagarService.getContaPagarByPessoa(pessoaId, pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarcaProduto(@PathVariable Long id) {
        contaPagarService.deleteContaPagar(id);
        return ResponseEntity.noContent().build();
    }
}
