package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.AcessoDeleteRequestDTO;
import br.com.altacommerce.dto.request.AcessoRequestDTO;
import br.com.altacommerce.dto.response.AcessoResponseDTO;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.model.Acesso;
import br.com.altacommerce.repository.AcessoRepository;
import br.com.altacommerce.service.validator.acesso.AcessoValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AcessoService {

    private final AcessoRepository acessoRepository;
    private final AcessoValidator acessoValidator;

    public AcessoService(AcessoRepository acessoRepository, AcessoValidator acessoValidator) {
        this.acessoRepository = acessoRepository;
        this.acessoValidator = acessoValidator;
    }

    @Transactional
    public AcessoResponseDTO createAcesso(AcessoRequestDTO dto){
        Acesso acesso = new Acesso(dto);
        acesso.setDescricao(acesso.getDescricao().toUpperCase());
        acessoValidator.verificarAcessoExistente(acesso.getDescricao());
        acessoRepository.save(acesso);
        return new AcessoResponseDTO(acesso);
    }

    @Transactional(readOnly = true)
    public AcessoResponseDTO getAcessoById(Long id){
        Acesso acesso = acessoRepository.findById(id).orElseThrow(() -> new NotFoundException("Acesso com id: " + id + " não encontrado"));
        return new AcessoResponseDTO(acesso);
    }

    @Transactional(readOnly = true)
    public Page<AcessoResponseDTO> getAllAcesso(String desc ,Pageable pageable){
        return acessoRepository.findByDescricaoContainingIgnoreCase(desc, pageable).map(AcessoResponseDTO::new);
    }

    @Transactional
    public void deleteAcesso(AcessoDeleteRequestDTO dto){
        Acesso acesso = acessoRepository.findById(dto.id()).orElseThrow(() -> new NotFoundException("Acesso com id: " + dto.id() + " não encontrado"));
        acessoRepository.delete(acesso);

    }

    @Transactional
    public void deleteAcessoPorID(Long id){
        Acesso acesso = acessoRepository.findById(id).orElseThrow(() -> new NotFoundException("Acesso com id: " + id + " não encontrado"));
        acessoRepository.delete(acesso);
    }
}
