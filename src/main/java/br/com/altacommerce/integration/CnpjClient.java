package br.com.altacommerce.integration;

import br.com.altacommerce.dto.response.ReceitaWsResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CnpjClient {

    private final WebClient receitaWsWebClient;

    public CnpjClient(WebClient receitaWsWebClient) {
        this.receitaWsWebClient = receitaWsWebClient;
    }

    public ReceitaWsResponseDTO buscarPorCpj(String cnpj){
        return receitaWsWebClient
                .get()
                .uri("/{cnpj}", cnpj)
                .retrieve()
                .bodyToMono(ReceitaWsResponseDTO.class)
                .block();
    }
}
