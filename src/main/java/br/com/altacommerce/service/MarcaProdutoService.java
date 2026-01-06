package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.MarcaProdutoRequestDTO;
import br.com.altacommerce.dto.response.MarcaProdutoResponseDTO;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.model.MarcaProduto;
import br.com.altacommerce.model.PessoaJuridica;
import br.com.altacommerce.repository.MarcaProdutoRepository;
import br.com.altacommerce.repository.PessoaJuridicaRepository;
import br.com.altacommerce.service.validator.marcaProduto.ValidatorMarcaProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarcaProdutoService {

    private final MarcaProdutoRepository marcaProdutoRepository;
    private final PessoaJuridicaRepository pessoaJuridicaRepository;
    private final List<ValidatorMarcaProduto> validators;

    public MarcaProdutoService(MarcaProdutoRepository marcaProdutoRepository, PessoaJuridicaRepository pessoaJuridicaRepository, List<ValidatorMarcaProduto> validators) {
        this.marcaProdutoRepository = marcaProdutoRepository;
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
        this.validators = validators;
    }

    @Transactional
    public MarcaProdutoResponseDTO createProduto(MarcaProdutoRequestDTO dto) {
        validators.forEach(v -> v.validate(dto));

        PessoaJuridica pessoaJuridica = pessoaJuridicaRepository.findById(dto.empresaId())
                .orElseThrow(() -> new NotFoundException("Empresa com Id: " + dto.empresaId() + " não encotrado"));

        MarcaProduto marcaProduto = new MarcaProduto(dto);
        marcaProduto.setEmpresa(pessoaJuridica);
        marcaProdutoRepository.save(marcaProduto);
        return new MarcaProdutoResponseDTO(marcaProduto);
    }

    @Transactional(readOnly = true)
    public MarcaProdutoResponseDTO getByIdMarcaProduto(Long id) {
        MarcaProduto marcaProduto = marcaProdutoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Marca do produto com Id: " + id + " não encotrado"));
        return new MarcaProdutoResponseDTO(marcaProduto);
    }

    @Transactional(readOnly = true)
    public Page<MarcaProdutoResponseDTO> getAllMarcaProdutoNome(String nomeDesc, Pageable pageable) {
        return marcaProdutoRepository.findByNomeDescContainingIgnoreCase(nomeDesc, pageable).map(MarcaProdutoResponseDTO::new);
    }

    @Transactional
    public void deleteMarcaProduto(Long id){
        MarcaProduto marcaProduto = marcaProdutoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Marca do produto com Id: " + id + " não encotrado"));
        marcaProdutoRepository.delete(marcaProduto);
    }
}
