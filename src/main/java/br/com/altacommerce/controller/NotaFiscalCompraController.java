package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.NotaFiscalCompraRequestDTO;
import br.com.altacommerce.dto.response.NotaFiscalCompraResponseDTO;
import br.com.altacommerce.service.NotaFiscalCompraService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/v1/nota-fiscal-compra")
public class NotaFiscalCompraController {

    private final NotaFiscalCompraService notaFiscalCompraService;

    public NotaFiscalCompraController(NotaFiscalCompraService notaFiscalCompraService) {
        this.notaFiscalCompraService = notaFiscalCompraService;
    }

    @PostMapping
    public ResponseEntity<NotaFiscalCompraResponseDTO> createNotaFiscalCompra(@Valid @RequestBody NotaFiscalCompraRequestDTO dto, UriComponentsBuilder uriBuilder){
        NotaFiscalCompraResponseDTO notaFiscalCompra = notaFiscalCompraService.createNotaFiscalCompra(dto);
        URI uri = uriBuilder.path("/api/v1/nota-fiscal-compra/{id}").buildAndExpand(notaFiscalCompra.id()).toUri();
        return ResponseEntity.created(uri).body(notaFiscalCompra);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<NotaFiscalCompraResponseDTO> getByIdContaPagar(@PathVariable Long id) {
        return ResponseEntity.ok().body(notaFiscalCompraService.getNotaFiscalCompraById(id));
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<Page<NotaFiscalCompraResponseDTO>> getAllNotaFiscalCompraDescricao(@PathVariable String descricao, Pageable pageable) {
        return ResponseEntity.ok().body(notaFiscalCompraService.getAllNotaFiscalCompraDescricao(descricao, pageable));
    }

    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<Page<NotaFiscalCompraResponseDTO>> listarPorPessoa(@PathVariable Long pessoaId, Pageable pageable) {
        return ResponseEntity.ok(notaFiscalCompraService.getContaPagarByPessoa(pessoaId, pageable));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotaFiscalCompra(@PathVariable Long id) {
        notaFiscalCompraService.deleteNotaFiscalCompra(id);
        return ResponseEntity.noContent().build();
    }

}
