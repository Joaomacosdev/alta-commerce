package br.com.altacommerce.service;

import br.com.altacommerce.dto.response.ReceitaWsResponseDTO;
import br.com.altacommerce.integration.CnpjClient;
import org.springframework.stereotype.Service;

@Service
public class CnpjService {

    private final CnpjClient cnpjClient;

    public CnpjService(CnpjClient cnpjClient) {
        this.cnpjClient = cnpjClient;
    }

    public ReceitaWsResponseDTO buscarPorCnpj(String cnpj){
       return cnpjClient.buscarPorCpj(cnpj);
    }
}
