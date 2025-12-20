package br.com.altacommerce.service;

import br.com.altacommerce.dto.response.CepResponseDTO;
import br.com.altacommerce.integration.CepClient;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final CepClient cepClient;

    public EnderecoService(CepClient cepClient) {
        this.cepClient = cepClient;
    }

    public CepResponseDTO buscarEnderecoPorCep(String cep){
        if (!cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP inválido");
        }
        return cepClient.buscarPorCep(cep);
    }
}
