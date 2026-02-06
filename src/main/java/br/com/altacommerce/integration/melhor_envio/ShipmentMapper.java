package br.com.altacommerce.integration.melhor_envio;

import br.com.altacommerce.integration.melhor_envio.cart.request.ShipmentRequestDTO;
import br.com.altacommerce.integration.melhor_envio.common.*;
import br.com.altacommerce.model.Endereco;
import br.com.altacommerce.model.PessoaJuridica;
import br.com.altacommerce.model.VdCpLoja;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShipmentMapper {

    public ShipmentRequestDTO toRequest(VdCpLoja venda) {

        PessoaJuridica empresa = venda.getEmpresa();
        Endereco enderecoEmpresa = empresa.getEnderecos()
                .stream()
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException("Empresa sem endereço cadastrado")
                );

        if (venda.getEnderecoEntrega() == null) {
            throw new IllegalStateException("Venda sem endereço de entrega");
        }

        if (venda.getItemVendaLojas().isEmpty()) {
            throw new IllegalStateException("Venda sem itens");
        }

        FromShipmentDTO from = new FromShipmentDTO(
                empresa.getRazaoSocial(),          // name
                empresa.getEmail(),                // email
                empresa.getTelefone(),             // phone
                null,                              // document
                empresa.getCnpj(),                 // company_document
                empresa.getInscEstadual(),         // state_register
                null,                              // economic_activity_code
                enderecoEmpresa.getRuaLogradouro(),// address
                enderecoEmpresa.getComplemento(),  // complement
                enderecoEmpresa.getNumero(),       // number
                enderecoEmpresa.getBairro(),       // district
                enderecoEmpresa.getCidade(),       // city
                enderecoEmpresa.getCep(),          // postal_code
                enderecoEmpresa.getUf()            // state_abbr
        );

        Endereco enderecoCliente = venda.getEnderecoEntrega();

        FromShipmentDTO to = new FromShipmentDTO(
                venda.getPessoa().getNome(),
                venda.getPessoa().getEmail(),
                venda.getPessoa().getTelefone(),
                venda.getPessoa().getDocumentoPrincipal(),        // document
                null,
                null,
                null,
                enderecoCliente.getRuaLogradouro(),
                enderecoCliente.getComplemento(),
                enderecoCliente.getNumero(),
                enderecoCliente.getBairro(),
                enderecoCliente.getCidade(),
                enderecoCliente.getCep(),
                enderecoCliente.getUf()
        );

        List<ProductDTO> products =
                venda.getItemVendaLojas().stream()
                        .map(item -> new ProductDTO(
                                item.getProduto().getNome(),
                                item.getQuantidade().toString(),
                                item.getProduto().getValorVenda().toString()
                        ))
                        .toList();

        List<VolumeDTO> volumes =
                venda.getItemVendaLojas().stream()
                        .map(item -> new VolumeDTO(
                                item.getProduto().getAltura().intValue(),
                                item.getProduto().getLargura().intValue(),
                                item.getProduto().getProfundidade().intValue(),
                                item.getProduto().getPeso().floatValue()
                        ))
                        .toList();


        OptionsDTO options = new OptionsDTO(
                venda.getValorTotal().doubleValue(),
                false,
                false,
                false,
                false
        );


        InvoiceDTO invoice =
                new InvoiceDTO(venda.getNotaFiscalvenda().getNumero());

        List<TagDTO> tags = List.of(
                new TagDTO(
                        "Pedido " + venda.getId(),
                        null
                )
        );

        return new ShipmentRequestDTO(
               1,
                49,
                from,
                to,
                products,
                volumes,
                options,
                invoice,
                empresa.getNomeFantasia(),
                tags
        );
    }
}

