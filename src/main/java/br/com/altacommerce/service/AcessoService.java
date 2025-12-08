package br.com.altacommerce.service;

import br.com.altacommerce.model.Acesso;
import br.com.altacommerce.repository.AcessoRepository;
import org.springframework.stereotype.Service;

@Service
public class AcessoService {

    private final AcessoRepository acessoRepository;

    public AcessoService(AcessoRepository acessoRepository) {
        this.acessoRepository = acessoRepository;
    }

    public Acesso createAcesso(Acesso acesso){
        return acessoRepository.save(acesso);
    }
}
