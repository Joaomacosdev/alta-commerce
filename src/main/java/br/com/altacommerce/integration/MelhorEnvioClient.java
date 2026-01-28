package br.com.altacommerce.integration;

import br.com.altacommerce.dto.melhor_envio.request.CalculoFreteRequestDTO;
import br.com.altacommerce.dto.melhor_envio.response.ServiceResponseDTO;
import org.springframework.core.ParameterizedTypeReference;
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
}
