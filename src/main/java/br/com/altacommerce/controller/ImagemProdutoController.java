package br.com.altacommerce.controller;

import br.com.altacommerce.dto.response.ImagemProdutoResponseDTO;
import br.com.altacommerce.service.UploadService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/imagem-produto")
public class ImagemProdutoController {

    private final UploadService uploadService;

    public ImagemProdutoController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page<ImagemProdutoResponseDTO>> getAllImagem(@PathVariable Long id, Pageable pageable){
        return ResponseEntity.ok().body(uploadService.findaAllImagemProdutos(id, pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImagem(@PathVariable Long id){
        uploadService.deleteImagem(id);
        return ResponseEntity.noContent().build();
    }
}
