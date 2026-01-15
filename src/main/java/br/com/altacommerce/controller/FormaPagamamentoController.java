package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.FormaPagamentoRequestDTO;
import br.com.altacommerce.dto.response.FormaPagamentoResponseDTO;
import br.com.altacommerce.service.FormaPagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("v1/api/forma-pagamento")
public class FormaPagamamentoController {

    private final FormaPagamentoService formaPagamentoService;

    public FormaPagamamentoController(FormaPagamentoService formaPagamentoService) {
        this.formaPagamentoService = formaPagamentoService;
    }

    @PostMapping
    public ResponseEntity<FormaPagamentoResponseDTO> createFormaPagamento(FormaPagamentoRequestDTO dto, UriComponentsBuilder uriBuilder){
        FormaPagamentoResponseDTO formaPagamento = formaPagamentoService.createFormaPagamento(dto);
        URI uri = uriBuilder.path("v1/api/forma-pagamento/{id}").buildAndExpand(formaPagamento.id()).toUri();
        return ResponseEntity.created(uri).body(formaPagamento);
    }
}
