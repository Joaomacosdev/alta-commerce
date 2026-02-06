package br.com.altacommerce.integration.melhor_envio.client;

import br.com.altacommerce.integration.melhor_envio.cart.request.ShipmentRequestDTO;
import br.com.altacommerce.integration.melhor_envio.checkout.request.ShipmentCheckoutRequestDTO;
import br.com.altacommerce.integration.melhor_envio.print.request.OrderRequestDTO;
import br.com.altacommerce.integration.melhor_envio.print.response.OrderResponseDTO;
import br.com.altacommerce.integration.melhor_envio.calculate.request.CalculoFreteRequestDTO;
import br.com.altacommerce.integration.melhor_envio.calculate.response.ServiceResponseDTO;
import br.com.altacommerce.integration.melhor_envio.checkout.response.ShipmentCheckoutResponseDTO;
import br.com.altacommerce.integration.melhor_envio.cart.response.ShipmentResponseDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class MelhorEnvioClient {

    private final WebClient melhorEnvioWebClient;

    public MelhorEnvioClient(WebClient melhorEnvioWebClient) {
        this.melhorEnvioWebClient = melhorEnvioWebClient;
    }

    public  List<ServiceResponseDTO> calcularFrete(CalculoFreteRequestDTO request){
        return melhorEnvioWebClient.post()
                .uri("/api/v2/me/shipment/calculate")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ServiceResponseDTO>>() {})
                .block();
    }

   public ShipmentResponseDTO inserirFreteCarrinho(ShipmentRequestDTO request){
        return melhorEnvioWebClient.post()
                .uri("/api/v2/me/cart")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        HttpStatusCode::isError,
                        response -> response.bodyToMono(String.class)
                                .map(body -> new RuntimeException(
                                        "Erro Melhor Envio: " + body
                                ))
                )
                .bodyToMono(ShipmentResponseDTO.class)
                .block();
   }

    public ShipmentCheckoutResponseDTO comprarEtiqueta(ShipmentCheckoutRequestDTO request){
        return melhorEnvioWebClient.post()
                .uri("/api/v2/me/shipment/checkout")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        HttpStatusCode::isError,
                        response -> response.bodyToMono(String.class)
                                .map(body -> new RuntimeException(
                                        "Erro Melhor Envio: " + body
                                ))
                )
                .bodyToMono(ShipmentCheckoutResponseDTO.class)
                .block();
    }


    public OrderResponseDTO imprimirEtiqueta(OrderRequestDTO request){
        return melhorEnvioWebClient.post()
                .uri("/api/v2/me/shipment/print")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        HttpStatusCode::isError,
                        response -> response.bodyToMono(String.class)
                                .map(body -> new RuntimeException(
                                        "Erro Melhor Envio: " + body
                                ))
                )
                .bodyToMono(OrderResponseDTO.class)
                .block();
    }
}
