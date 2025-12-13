package br.com.altacommerce.service.validator;

import br.com.altacommerce.infra.exception.BusinessException;
import br.com.altacommerce.repository.AcessoRepository;
import org.springframework.stereotype.Component;

@Component
public class AcessoValidator {

    private final AcessoRepository acessoRepository;

    public AcessoValidator(AcessoRepository acessoRepository) {
        this.acessoRepository = acessoRepository;
    }

    public void verificarSalaExistente(String descricao){
        if (acessoRepository.existsByDescricao(descricao)){
            throw new BusinessException("Acesso com descrição: " + descricao + " já existe" );
        }
    }

}
