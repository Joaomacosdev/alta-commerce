package br.com.altacommerce.service;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;


@Service
public class UploadService {

    private static final int LARGURA_PADRAO = 800;
    private static final int ALTURA_PADRAO = 600;

    public String gerarMiniaturaBase64(String imagemBase64) {
        try {
            String base64 = limparPrefixo(imagemBase64);

            byte[] bytes = Base64.getDecoder().decode(base64);
            BufferedImage original = ImageIO.read(new ByteArrayInputStream(bytes));

            if (original == null) {
                throw new IllegalArgumentException("Imagem inválida");
            }

            BufferedImage resized = redimensionar(original, LARGURA_PADRAO, ALTURA_PADRAO);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(resized, "png", baos);

            return "data:image/png;base64," +
                    Base64.getEncoder().encodeToString(baos.toByteArray());

        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar imagem", e);
        }
    }

    private BufferedImage redimensionar(BufferedImage original, int largura, int altura) {

        int tipo = original.getType() == 0
                ? BufferedImage.TYPE_INT_ARGB
                : original.getType();

        BufferedImage novaImagem = new BufferedImage(largura, altura, tipo);
        Graphics2D g = novaImagem.createGraphics();

        g.drawImage(original, 0, 0, largura, altura, null);
        g.dispose();

        return novaImagem;
    }

    private String limparPrefixo(String imagemBase64) {
        if (imagemBase64.contains("data:image")) {
            return imagemBase64.split(",")[1];
        }
        return imagemBase64;
    }}
