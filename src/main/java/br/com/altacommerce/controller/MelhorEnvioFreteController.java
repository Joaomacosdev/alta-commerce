package br.com.altacommerce.controller;

import br.com.altacommerce.dto.melhor_envio.request.CalculoFreteRequestDTO;
import br.com.altacommerce.dto.melhor_envio.response.ServiceResponseDTO;
import br.com.altacommerce.service.MelhorEnvioFreteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/melhor-envio")
public class MelhorEnvioFreteController {

    private final MelhorEnvioFreteService melhorEnvioFreteService;

    public MelhorEnvioFreteController(MelhorEnvioFreteService melhorEnvioFreteService) {
        this.melhorEnvioFreteService = melhorEnvioFreteService;
    }

    @PostMapping
    public ResponseEntity<List<ServiceResponseDTO>> calcularFrete(@Valid @RequestBody CalculoFreteRequestDTO request){
        return ResponseEntity.ok().body(melhorEnvioFreteService.calcularFrete(request));
    }
}
