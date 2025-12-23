package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.EnderecoRequestDTO;
import br.com.altacommerce.dto.response.CepResponseDTO;
import br.com.altacommerce.integration.CepClient;
import br.com.altacommerce.model.Endereco;
import br.com.altacommerce.model.Pessoa;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final CepClient cepClient;

    public EnderecoService(CepClient cepClient) {
        this.cepClient = cepClient;
    }

    @Cacheable(
            value = "cep-cache",
            key = "#cep",
            unless = "#result == null"

    )
    public CepResponseDTO buscarEnderecoPorCep(String cep){
        if (!cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP inválido");
        }
        return cepClient.buscarPorCep(cep);
    }

    public Endereco criarEnderecoComCep(Pessoa pessoa, EnderecoRequestDTO dto){
        CepResponseDTO cepResponse = buscarEnderecoPorCep(dto.cep());
        Endereco endereco = new Endereco();
        endereco.setPessoa(pessoa);
        endereco.setCep(cepResponse.cep());
        endereco.setBairro(cepResponse.bairro());
        endereco.setCidade(cepResponse.localidade());
        endereco.setUf(cepResponse.uf());
        endereco.setNumero(dto.numero());
        endereco.setComplemento(dto.complemento());
        endereco.setRuaLogradouro(dto.ruaLogradouro());
        endereco.setTipoEndereco(dto.tipoEndereco());
        endereco.setTipoEndereco(dto.tipoEndereco());

        return endereco;
    }
}
