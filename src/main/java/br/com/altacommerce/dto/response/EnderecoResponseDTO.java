package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.Pessoa;
import br.com.altacommerce.model.enums.TipoEndereco;


public record EnderecoResponseDTO(
        Long id,
        String ruaLogradouro,
        String cep,
        String numero,
        String complemento,
        String bairro,
        String uf,
        String cidade,
        Pessoa pessoa,
        TipoEndereco tipoEndereco,
        Long empresaId
) {
}
