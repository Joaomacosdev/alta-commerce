package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.PessoaFisicaRequestDTO;
import br.com.altacommerce.dto.response.PessoaFisicaResponseDTO;
import br.com.altacommerce.service.PessoaFisicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
