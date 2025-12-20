package br.com.altacommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ViaCepWebClientConfig {

    @Value("${external.api.viacep.base-url}")
    private String baseUrl;

    @Bean
    public WebClient viaCepWebClient(WebClient.Builder builder){
        return builder
                .baseUrl(baseUrl)
                .build();
    }
}
