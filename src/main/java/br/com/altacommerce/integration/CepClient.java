package br.com.altacommerce.integration;

import br.com.altacommerce.dto.response.CepResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CepClient {

    private final WebClient viaCepWebClient;

    public CepClient(WebClient viaCepWebClient) {
        this.viaCepWebClient = viaCepWebClient;
    }

    public CepResponseDTO buscarPorCep(String cep){
        return viaCepWebClient
                .get()
                .uri("/{cep}/json/", cep)
                .retrieve()
                .bodyToMono(CepResponseDTO.class)
                .block();
    }


}
