package br.com.altacommerce.service.validator.marcaProduto;

import br.com.altacommerce.dto.request.MarcaProdutoRequestDTO;
import br.com.altacommerce.infra.exception.BusinessException;
import br.com.altacommerce.repository.MarcaProdutoRepository;
import org.springframework.stereotype.Component;

@Component
public class NomeDescExistente implements ValidatorMarcaProduto{

    private final MarcaProdutoRepository marcaProdutoRepository;

    public NomeDescExistente(MarcaProdutoRepository marcaProdutoRepository) {
        this.marcaProdutoRepository = marcaProdutoRepository;
    }


    @Override
    public void validate(MarcaProdutoRequestDTO dto) {
        if (marcaProdutoRepository.existsByNomeDesc(dto.nomeDesc())){
            throw new BusinessException("Marca do produto com o nome: " + dto.nomeDesc() + " já cadastrado");
        }
    }
}
