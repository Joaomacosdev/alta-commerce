package br.com.altacommerce.controller;

import br.com.altacommerce.dto.response.CepResponseDTO;
import br.com.altacommerce.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<CepResponseDTO> buscarPorCep(@PathVariable String cep){
        return ResponseEntity.ok(enderecoService.buscarEnderecoPorCep(cep));
    }
}
