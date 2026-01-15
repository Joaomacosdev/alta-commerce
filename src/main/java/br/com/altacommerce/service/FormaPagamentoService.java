package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.FormaPagamentoRequestDTO;
import br.com.altacommerce.dto.response.FormaPagamentoResponseDTO;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.model.FormaPagamento;
import br.com.altacommerce.model.PessoaJuridica;
import br.com.altacommerce.repository.FormaPagamentoRepository;
import br.com.altacommerce.repository.PessoaJuridicaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FormaPagamentoService {

    private final FormaPagamentoRepository formaPagamentoRepository;
    private final PessoaJuridicaRepository pessoaJuridicaRepository;

    public FormaPagamentoService(FormaPagamentoRepository formaPagamentoRepository, PessoaJuridicaRepository pessoaJuridicaRepository) {
        this.formaPagamentoRepository = formaPagamentoRepository;
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
    }

    @Transactional
    public FormaPagamentoResponseDTO createFormaPagamento(FormaPagamentoRequestDTO dto){

        PessoaJuridica empresa = pessoaJuridicaRepository.findById(dto.empresaId())
                .orElseThrow(() -> new NotFoundException("Empresa não encontrada"));

        FormaPagamento formaPagamento = new FormaPagamento(dto);
        formaPagamento.setEmpresa(empresa);
        formaPagamentoRepository.save(formaPagamento);
        return new FormaPagamentoResponseDTO(formaPagamento);
    }
}
