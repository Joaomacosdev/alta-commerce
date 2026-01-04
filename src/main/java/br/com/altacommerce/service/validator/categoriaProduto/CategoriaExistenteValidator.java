package br.com.altacommerce.service.validator.categoriaProduto;

import br.com.altacommerce.dto.request.CategoriaProdutoRequestDTO;
import br.com.altacommerce.infra.exception.BusinessException;
import br.com.altacommerce.repository.CategoriaProdutoRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoriaExistenteValidator implements ValidatorCategoriaProduto{

    private final CategoriaProdutoRepository categoriaProdutoRepository;

    public CategoriaExistenteValidator(CategoriaProdutoRepository categoriaProdutoRepository) {
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }

    @Override
    public void validate(CategoriaProdutoRequestDTO dto) {
        if (categoriaProdutoRepository.existsByNomeDescIgnoreCaseAndEmpresaId(dto.nomeDesc(), dto.empresaId())){
            throw new BusinessException("Já existe uma categoria com esse nome para a empresa informada.");
        }
    }
}
