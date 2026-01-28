package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.VdCpLojaRequestDTO;
import br.com.altacommerce.dto.response.VdCpLojaResponseDTO;
import br.com.altacommerce.service.VdCpLojaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("v1/api/vd-cp-loja")
public class VdCpLojaController {

    private final VdCpLojaService vdCpLojaService;

    public VdCpLojaController(VdCpLojaService vdCpLojaService) {
        this.vdCpLojaService = vdCpLojaService;
    }

    @PostMapping
    public ResponseEntity<VdCpLojaResponseDTO> createVdCpLoja(@Valid @RequestBody VdCpLojaRequestDTO dto, UriComponentsBuilder uriBuilder){
        VdCpLojaResponseDTO vdCpLoja = vdCpLojaService.createVdCpLoja(dto);
        URI uri = uriBuilder.path("v1/api/vd-cp-loja/{id}").buildAndExpand(vdCpLoja.id()).toUri();
        return ResponseEntity.created(uri).body(vdCpLoja);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<VdCpLojaResponseDTO> getByIdVdCppLoja(@PathVariable Long id){
        return ResponseEntity.ok().body(vdCpLojaService.getByIdVdCpLoja(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Page<VdCpLojaResponseDTO>> getByAllByVendaProdutoNome(@PathVariable String nome, Pageable pageable){
        return ResponseEntity.ok().body(vdCpLojaService.getAllVendaProdutoNome(nome, pageable));
    }

    @GetMapping("/cliente/{nome}")
    public ResponseEntity<Page<VdCpLojaResponseDTO>> getByAllByVendaClienteNome(@PathVariable String nome, Pageable pageable){
        return ResponseEntity.ok().body(vdCpLojaService.getAllVendaClienteNome(nome, pageable));
    }

    @GetMapping("/cliente/{cpf}")
    public ResponseEntity<Page<VdCpLojaResponseDTO>> getByAllByVendaClienteCpf(@PathVariable String cpf, Pageable pageable){
        return ResponseEntity.ok().body(vdCpLojaService.getAllVendaClienteCpf(cpf, pageable));
    }

    @GetMapping("/data/{inicio}/{fim}")
    public ResponseEntity<Page<VdCpLojaResponseDTO>> getByVendaDataVenda(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
            Pageable pageable
    ) {
        return ResponseEntity.ok(
                vdCpLojaService.getAllVendaDataVenda(inicio, fim, pageable)
        );
    }


    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteIdVdCppLoja(@PathVariable Long id){
        vdCpLojaService.excluirVenda(id);
        return ResponseEntity.noContent().build();
    }
}
