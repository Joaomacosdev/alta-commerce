package br.com.altacommerce.service.validator.produto;

import br.com.altacommerce.dto.request.ProdutoRequestDTO;
import br.com.altacommerce.infra.exception.BusinessException;
import br.com.altacommerce.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

@Component
public class NomeProdutoExistenteValidator implements ValidatorProduto{

    private final ProdutoRepository produtoRepository;

    public NomeProdutoExistenteValidator(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    public void validate(ProdutoRequestDTO dto) {
        if (produtoRepository.existsByNome(dto.nome())){
            throw new BusinessException("Produto com nome " + dto.nome() + " já existe");
        }
    }
}
