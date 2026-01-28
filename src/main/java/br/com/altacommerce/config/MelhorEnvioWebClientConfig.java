package br.com.altacommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MelhorEnvioWebClientConfig {

    @Value("${external.api.melhor-envio.base-url}")
    private String baseUrl;

    @Value("${external.api.melhor-envio.token}")
    private String token;

    @Value("${external.api.melhor-envio.user-agent}")
    private String userAgent;

    @Bean
    public WebClient melhorEnvioWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .defaultHeader(HttpHeaders.USER_AGENT, userAgent)
                .build();
    }
}
