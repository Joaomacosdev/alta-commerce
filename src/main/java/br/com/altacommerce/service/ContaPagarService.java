package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.ContaPagarRequestDTO;
import br.com.altacommerce.dto.response.ContaPagarResponseDTO;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.model.ContaPagar;
import br.com.altacommerce.model.Pessoa;
import br.com.altacommerce.model.PessoaJuridica;
import br.com.altacommerce.model.enums.StatusContaPagar;
import br.com.altacommerce.repository.ContaPagarRepository;
import br.com.altacommerce.repository.PessoaJuridicaRepository;
import br.com.altacommerce.repository.PessoaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContaPagarService {

    private final ContaPagarRepository contaPagarRepository;
    private final PessoaJuridicaRepository pessoaJuridicaRepository;
    private final PessoaRepository pessoaRepository;

    public ContaPagarService(ContaPagarRepository contaPagarRepository, PessoaJuridicaRepository pessoaJuridicaRepository, PessoaRepository pessoaRepository) {
        this.contaPagarRepository = contaPagarRepository;
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public ContaPagarResponseDTO createContaPagar(ContaPagarRequestDTO dto) {
        ContaPagar contaPagar = motarContaPagar(dto);
        contaPagarRepository.save(contaPagar);
        return new ContaPagarResponseDTO(contaPagar);
    }

    @Transactional(readOnly = true)
    public ContaPagarResponseDTO getByIdContaPagar(Long id) {
        ContaPagar contaPagar = contaPagarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Conta a pagar com Id: " + id + " não encotrado"));
        return new ContaPagarResponseDTO(contaPagar);
    }

    @Transactional(readOnly = true)
    public Page<ContaPagarResponseDTO> getAllMarcaContaPagarDescricao(String descricao, Pageable pageable) {
        return contaPagarRepository.findByDescricaoContainingIgnoreCase(descricao, pageable).map(ContaPagarResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<ContaPagarResponseDTO> getContaPagarByPessoa(Long pessoaId, Pageable pageable) {
        pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new NotFoundException("Pessoa com id: " + pessoaId + " não encontrada"));
        return contaPagarRepository.findByPessoaId(pessoaId, pageable).map(ContaPagarResponseDTO::new);
    }

    @Transactional
    public void deleteContaPagar(Long id) {
        ContaPagar contaPagar = contaPagarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Conta a pagar com Id: " + id + " não encotrado"));
        contaPagarRepository.delete(contaPagar);

    }


    //----------------------------------------------------//

    private ContaPagar motarContaPagar(ContaPagarRequestDTO dto) {
        ContaPagar contaPagar = new ContaPagar(dto);
        contaPagar.setPessoa(buscarPessoaId(dto.pessoaId()));
        contaPagar.setPessoaFornecedor(buscarFornecedorId(dto.pessoaFornecedorId()));
        contaPagar.setEmpresa(buscarEmpresaId(dto.empresaId()));

        contaPagar.setStatus(StatusContaPagar.cobranca);

        return contaPagar;
    }

    private PessoaJuridica buscarEmpresaId(Long id) {
        return pessoaJuridicaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Empresa com id: " + id + " não encotrado"));
    }

    private PessoaJuridica buscarFornecedorId(Long id) {
        return pessoaJuridicaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Fornecedor com id: " + id + " não encotrado"));
    }

    private Pessoa buscarPessoaId(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa com id: " + id + " não encotrado"));
    }
}
