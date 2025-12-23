package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.PessoaFisicaRequestDTO;
import br.com.altacommerce.dto.response.PessoaFisicaResponseDTO;
import br.com.altacommerce.service.PessoaFisicaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/v1/pessoa-fisica")
public class PessoaFisicaController {

    private final PessoaFisicaService pessoaFisicaService;

    public PessoaFisicaController(PessoaFisicaService pessoaFisicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
    }

    @PostMapping
    public ResponseEntity<PessoaFisicaResponseDTO> createPessoaFisica(@Valid @RequestBody PessoaFisicaRequestDTO dto, UriComponentsBuilder uriBuilder){
        PessoaFisicaResponseDTO pessoaFisica = pessoaFisicaService.createPessoaFisica(dto);
        URI uri = uriBuilder.path("api/v1/pessoa-fisica/{id}").buildAndExpand(pessoaFisica.id()).toUri();
        return ResponseEntity.created(uri).body(pessoaFisica);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<PessoaFisicaResponseDTO> getPessoaFisicaCpf(@PathVariable String cpf){
        return ResponseEntity.ok().body(pessoaFisicaService.getPessoaFisicaCpf(cpf));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Page<PessoaFisicaResponseDTO>> getAllPessoaFisicaome(@PathVariable String nome, Pageable pageable){
        return ResponseEntity.ok().body(pessoaFisicaService.getAllPessoaFisicaNome(nome, pageable));
    }

    @GetMapping("/listar/cpf/{cpf}")
    public ResponseEntity<Page<PessoaFisicaResponseDTO>> getAllPessoaFisicaCpf(@PathVariable String cpf, Pageable pageable){
        return ResponseEntity.ok().body(pessoaFisicaService.getAllPessoaFisicaCpf(cpf, pageable));
    }
}
