package br.com.altacommerce.service;

import br.com.altacommerce.dto.melhor_envio.request.CalculoFreteRequestDTO;
import br.com.altacommerce.dto.melhor_envio.response.ServiceResponseDTO;
import br.com.altacommerce.integration.MelhorEnvioClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MelhorEnvioFreteService {

    private final MelhorEnvioClient melhorEnvioClient;

    public MelhorEnvioFreteService(MelhorEnvioClient melhorEnvioClient) {
        this.melhorEnvioClient = melhorEnvioClient;
    }

    public List<ServiceResponseDTO> calcularFrete(CalculoFreteRequestDTO request){
       return melhorEnvioClient.calcularFrete(request);
    }
}
