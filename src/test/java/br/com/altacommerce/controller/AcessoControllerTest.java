package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.AcessoRequestDTO;
import br.com.altacommerce.dto.response.AcessoResponseDTO;
import br.com.altacommerce.model.Acesso;
import br.com.altacommerce.repository.AcessoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AcessoControllerTest {


    @Autowired
    private AcessoController acessoController;

    @Autowired
    private AcessoRepository acessoRepository;


    @Nested
    class CadastrarAcesso {

        @DisplayName("Então deve executar com sucesso")
        @Nested
        class Sucesso {

            @DisplayName("Dado um acesso com todos os campos")
            @Test
            @Transactional
            void deveCadastrarAcessoComSucesso() {

                // Dado
                AcessoRequestDTO dto = new AcessoRequestDTO("ROLE_TESTE");

                // Quando
                var response = acessoController.createAcesso(dto, UriComponentsBuilder.newInstance());

                // Então
                assertNotNull(response);
                assertTrue(response.getStatusCode().is2xxSuccessful());

                AcessoResponseDTO body = response.getBody();

                assertNotNull(body);
                assertNotNull(body.id());
                assertEquals("ROLE_TESTE", body.descricao());
            }

            @DisplayName("Deve excluir um acesso com sucesso")
            @Test
            @Transactional
            void deveExcluirAcessoComSucesso() {

                // Dado
                Acesso acesso = new Acesso();
                acesso.setDescricao("ROLE_TESTE");
                acesso = acessoRepository.save(acesso);

                Long id = acesso.getId();

                // Quando
                var response = acessoController.deleteAcesso(id);

                // Então
                assertNotNull(response);
                assertEquals(204, response.getStatusCode().value());
                assertNull(response.getBody()); // 204 SEM BODY

                // Verifica se realmente foi deletado
                boolean exists = acessoRepository.existsById(id);
                assertFalse(exists);
            }
        }
    }

}