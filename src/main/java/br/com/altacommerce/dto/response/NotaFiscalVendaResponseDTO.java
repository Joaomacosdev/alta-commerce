package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.NotaFiscalvenda;

public record NotaFiscalVendaResponseDTO(

        Long id,
        String numero,
        String serie,
        String tipo,
        String xml,
        String pdf

) {
    public NotaFiscalVendaResponseDTO(NotaFiscalvenda notaFiscalvenda) {
        this(notaFiscalvenda.getId(),
                notaFiscalvenda.getNumero(),
                notaFiscalvenda.getSerie(),
                notaFiscalvenda.getTipo(),
                notaFiscalvenda.getXml(),
                notaFiscalvenda.getPdf());
    }
}
