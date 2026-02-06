package br.com.altacommerce.controller;

import br.com.altacommerce.integration.melhor_envio.cart.request.ShipmentRequestDTO;
import br.com.altacommerce.integration.melhor_envio.checkout.request.ShipmentCheckoutRequestDTO;
import br.com.altacommerce.integration.melhor_envio.print.request.OrderRequestDTO;
import br.com.altacommerce.integration.melhor_envio.print.response.OrderResponseDTO;
import br.com.altacommerce.integration.melhor_envio.calculate.request.CalculoFreteRequestDTO;
import br.com.altacommerce.integration.melhor_envio.calculate.response.ServiceResponseDTO;
import br.com.altacommerce.integration.melhor_envio.checkout.response.ShipmentCheckoutResponseDTO;
import br.com.altacommerce.integration.melhor_envio.cart.response.ShipmentResponseDTO;
import br.com.altacommerce.service.MelhorEnvioFreteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/melhor-envio")
public class MelhorEnvioFreteController {

    private final MelhorEnvioFreteService melhorEnvioFreteService;

    public MelhorEnvioFreteController(MelhorEnvioFreteService melhorEnvioFreteService) {
        this.melhorEnvioFreteService = melhorEnvioFreteService;
    }

    @PostMapping("/calcular-frete")
    public ResponseEntity<List<ServiceResponseDTO>> calcularFrete(@Valid @RequestBody CalculoFreteRequestDTO request){
        return ResponseEntity.ok().body(melhorEnvioFreteService.calcularFrete(request));
    }

    @PostMapping("/inserir-frete-carrinho/{id}")
    public ResponseEntity<ShipmentResponseDTO> inserirFreteCarrinho(@PathVariable Long id){
        return ResponseEntity.ok().body(melhorEnvioFreteService.inserirFreteCarrinho(id));
    }

    @PostMapping("/comprar-etiqueta/{id}")
    public ResponseEntity<ShipmentCheckoutResponseDTO> comprarEtiqueta(@PathVariable Long id){
        return ResponseEntity.ok().body(melhorEnvioFreteService.comprarEtiqueta(id));
    }

    @PostMapping("/imprimir-etiqueta/{id}")
    public ResponseEntity<OrderResponseDTO> imprimirEtiqueta(@PathVariable Long id){
        return ResponseEntity.ok().body(melhorEnvioFreteService.imprimirEtiqueta(id));
    }
}
