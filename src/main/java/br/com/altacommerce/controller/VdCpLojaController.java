package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.VdCpLojaRequestDTO;
import br.com.altacommerce.dto.response.VdCpLojaResponseDTO;
import br.com.altacommerce.service.VdCpLojaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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
}
