package br.com.altacommerce.service;

import br.com.altacommerce.infra.exception.BusinessException;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.integration.melhor_envio.ShipmentMapper;
import br.com.altacommerce.integration.melhor_envio.calculate.request.CalculoFreteRequestDTO;
import br.com.altacommerce.integration.melhor_envio.calculate.response.ServiceResponseDTO;
import br.com.altacommerce.integration.melhor_envio.cart.request.ShipmentRequestDTO;
import br.com.altacommerce.integration.melhor_envio.cart.response.ShipmentResponseDTO;
import br.com.altacommerce.integration.melhor_envio.checkout.request.ShipmentCheckoutRequestDTO;
import br.com.altacommerce.integration.melhor_envio.checkout.response.ShipmentCheckoutResponseDTO;
import br.com.altacommerce.integration.melhor_envio.client.MelhorEnvioClient;
import br.com.altacommerce.integration.melhor_envio.print.request.OrderRequestDTO;
import br.com.altacommerce.integration.melhor_envio.print.response.OrderResponseDTO;
import br.com.altacommerce.model.VdCpLoja;
import br.com.altacommerce.repository.VdCpLojaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MelhorEnvioFreteService {

    private final MelhorEnvioClient melhorEnvioClient;
    private final VdCpLojaRepository vdCpLojaRepository;
    private final ShipmentMapper shipmentMapper;

    public MelhorEnvioFreteService(MelhorEnvioClient melhorEnvioClient, VdCpLojaRepository vdCpLojaRepository, ShipmentMapper shipmentMapper) {
        this.melhorEnvioClient = melhorEnvioClient;
        this.vdCpLojaRepository = vdCpLojaRepository;
        this.shipmentMapper = shipmentMapper;
    }

    public List<ServiceResponseDTO> calcularFrete(CalculoFreteRequestDTO request) {
        return melhorEnvioClient.calcularFrete(request);
    }

    @Transactional
    public ShipmentResponseDTO inserirFreteCarrinho(Long vendaId) {

        VdCpLoja venda = buscarVenda(vendaId);
        validarFreteNaoInserido(venda);

        ShipmentRequestDTO request = shipmentMapper.toRequest(venda);
        ShipmentResponseDTO response = melhorEnvioClient.inserirFreteCarrinho(request);

        venda.setCodigoEtiqueta(response.id());
        venda.setServicoTransportadora(response.serviceId());


        return response;
    }

    @Transactional
    public ShipmentCheckoutResponseDTO comprarEtiqueta(Long vendaId) {
        VdCpLoja venda = buscarVenda(vendaId);

        String melhorEnvioOrderId = obterOrderId(venda);

        ShipmentCheckoutRequestDTO request =
                new ShipmentCheckoutRequestDTO(List.of(melhorEnvioOrderId));

        return melhorEnvioClient.comprarEtiqueta(request);
    }

    @Transactional
    public OrderResponseDTO imprimirEtiqueta(Long vendaId) {
        VdCpLoja venda = buscarVenda(vendaId);
        String melhorEnvioOrderId = obterOrderId(venda);

        OrderRequestDTO request = new OrderRequestDTO("public",  List.of(melhorEnvioOrderId));

        OrderResponseDTO response = melhorEnvioClient.imprimirEtiqueta(request);

        venda.setUrlImprimiEtiqueta(response.url());

        return response;
    }

    private VdCpLoja buscarVenda(Long id) {
        return vdCpLojaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Venda não encontrada"));
    }

    private void validarFreteNaoInserido(VdCpLoja venda) {
        if (venda.getCodigoEtiqueta() != null) {
            throw new BusinessException("Frete já inserido");
        }
    }

    private String obterOrderId(VdCpLoja venda) {
        if (venda.getCodigoEtiqueta() == null) {
            throw new BusinessException("Venda não possui order do Melhor Envio");
        }
        return venda.getCodigoEtiqueta();
    }


}
