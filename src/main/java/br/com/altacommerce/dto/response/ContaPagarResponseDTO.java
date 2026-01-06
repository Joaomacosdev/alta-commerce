package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.ContaPagar;
import br.com.altacommerce.model.Pessoa;
import br.com.altacommerce.model.enums.StatusContaPagar;

import java.math.BigDecimal;
import java.util.Date;

public record ContaPagarResponseDTO(

        Long id,
        String descricao,
        Date dtVencimento,
        Date dtPagamento,
        BigDecimal valorTotal,
        BigDecimal valorDesconto,
        StatusContaPagar status,

        PessoaResponseDTO pessoa,
        PessoaJuridicaResponseDTO pessoaFornecedor,
        PessoaJuridicaResponseDTO empresa
) {
    public ContaPagarResponseDTO(ContaPagar contaPagar) {
        this(
                contaPagar.getId(),
                contaPagar.getDescricao(),
                contaPagar.getDtVencimento(),
                contaPagar.getDtPagamento(),
                contaPagar.getValorTotal(),
                contaPagar.getValorDesconto(),
                contaPagar.getStatus(),
                new PessoaResponseDTO(contaPagar.getPessoa()),
                new PessoaJuridicaResponseDTO(contaPagar.getPessoaFornecedor()),
                new PessoaJuridicaResponseDTO(contaPagar.getEmpresa())
        );
    }
}
