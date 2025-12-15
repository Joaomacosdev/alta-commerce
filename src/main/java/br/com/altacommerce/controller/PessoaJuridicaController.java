package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.PessoaJuridicaRequestDTO;
import br.com.altacommerce.dto.response.PessoaJuridicaResponseDTO;
import br.com.altacommerce.service.PessoaJuridicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
