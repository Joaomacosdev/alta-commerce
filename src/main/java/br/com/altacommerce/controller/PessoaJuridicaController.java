package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.PessoaJuridicaRequestDTO;
import br.com.altacommerce.dto.response.PessoaJuridicaResponseDTO;
import br.com.altacommerce.service.PessoaJuridicaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/v1/pessoa-juridica")
public class PessoaJuridicaController {

    private final PessoaJuridicaService pessoaJuridicaService;

    public PessoaJuridicaController(PessoaJuridicaService pessoaJuridicaService) {
        this.pessoaJuridicaService = pessoaJuridicaService;
    }

    @PostMapping
    public ResponseEntity<PessoaJuridicaResponseDTO> createPessoaJuridica(@Valid @RequestBody PessoaJuridicaRequestDTO dto, UriComponentsBuilder uriBuilder){
        PessoaJuridicaResponseDTO juridicaResponse = pessoaJuridicaService.createPessoaJuridica(dto);
        URI uri = uriBuilder.path("api/v1/juridica/{id}").buildAndExpand(juridicaResponse.id()).toUri();
        return ResponseEntity.created(uri).body(juridicaResponse);

    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<PessoaJuridicaResponseDTO> getPessoaJuridicaCnpj(@PathVariable String cnpj){
        return ResponseEntity.ok().body(pessoaJuridicaService.getPessoaJuridicaCnpj(cnpj));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Page<PessoaJuridicaResponseDTO>> getAllPessoaJuridica(@PathVariable String nome, Pageable pageable){
        return ResponseEntity.ok().body(pessoaJuridicaService.getAllPessoa(nome, pageable));
    }

    @GetMapping("/listar/cnpj/{cnpj}")
    public ResponseEntity<Page<PessoaJuridicaResponseDTO>> getAllPessoaJuridicaCnpj(@PathVariable String cnpj, Pageable pageable){
        return ResponseEntity.ok().body(pessoaJuridicaService.getAllPessoaJuridicaCnpj(cnpj, pageable));
    }
}
