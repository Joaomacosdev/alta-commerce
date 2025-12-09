package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.AcessoRequestDTO;
import br.com.altacommerce.dto.response.AcessoResponseDTO;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.model.Acesso;
import br.com.altacommerce.repository.AcessoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AcessoService {

    private final AcessoRepository acessoRepository;

    public AcessoService(AcessoRepository acessoRepository) {
        this.acessoRepository = acessoRepository;
    }

    @Transactional
    public AcessoResponseDTO createAcesso(AcessoRequestDTO dto){
        Acesso acesso = new Acesso(dto);
        acessoRepository.save(acesso);
        return new AcessoResponseDTO(acesso);
    }

    @Transactional
    public void deleteAcesso(Long id){
        Acesso acesso = acessoRepository.findById(id).orElseThrow(() -> new NotFoundException("Acesso com id: " + id + " não encontrado"));
        acessoRepository.delete(acesso);
    }
}
