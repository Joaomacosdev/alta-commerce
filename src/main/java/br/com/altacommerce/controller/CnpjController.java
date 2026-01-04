package br.com.altacommerce.controller;

import br.com.altacommerce.dto.response.ReceitaWsResponseDTO;
import br.com.altacommerce.service.CnpjService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cnpj")
public class CnpjController {

    private final CnpjService cnpjService;

    public CnpjController(CnpjService cnpjService) {
        this.cnpjService = cnpjService;
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<ReceitaWsResponseDTO> buscarPorCnpj(@PathVariable String cnpj){
        return ResponseEntity.ok().body(cnpjService.buscarPorCnpj(cnpj));
    }
}
