package br.com.altacommerce.controller;

import br.com.altacommerce.dto.request.AcessoRequestDTO;
import br.com.altacommerce.model.Acesso;
import br.com.altacommerce.repository.AcessoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class AcessoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AcessoRepository acessoRepository;



    @Nested
    class Sucesso {


        @Test
        @DisplayName("Deve cadastrar um acesso com sucesso")
        void deveCadastrarAcessoComSucesso() throws Exception {

            String json = """
                {
                    "descricao": "ROLE_TESTE"
                }
            """;

            mockMvc.perform(post("/api/v1/acesso")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id").exists())
                    .andExpect(jsonPath("$.descricao").value("ROLE_TESTE"));
        }

        @Test
        @DisplayName("Deve retornar acesso por ID com sucesso")
        void deveRetornarAcessoPorId() throws Exception {

            // GIVEN
            Acesso acesso = new Acesso();
            acesso.setDescricao("ROLE_BUSCA");
            acesso = acessoRepository.save(acesso);

            Long id = acesso.getId();

            // WHEN + THEN
            mockMvc.perform(get("/api/v1/acesso/id/{id}", id))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(id))
                    .andExpect(jsonPath("$.descricao").value("ROLE_BUSCA"));
        }

        @Test
        @DisplayName("Deve retornar página de acessos filtrados por descrição")
        void deveRetornarAcessosFiltradosPorDescricao() throws Exception {


            acessoRepository.deleteAll();


            // GIVEN
            AcessoRequestDTO dto1 = new AcessoRequestDTO("ROLE_ADMIN");
            AcessoRequestDTO dto2 = new AcessoRequestDTO("ROLE_USER");
            AcessoRequestDTO dto3 = new AcessoRequestDTO("ROLE_SUPERVISOR");

            acessoRepository.save(new Acesso(dto1));
            acessoRepository.save(new Acesso(dto2));
            acessoRepository.save(new Acesso(dto3));

            // WHEN
            mockMvc.perform(get("/api/v1/acesso/desc/{desc}", "ROLE")
                            .param("page", "0")
                            .param("size", "10"))
                    // THEN
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.content.length()").value(3))
                    .andExpect(jsonPath("$.totalElements").value(3))
                    .andExpect(jsonPath("$.content[0].descricao").exists());
        }


        @Test
        @DisplayName("Deve excluir um acesso por ID com sucesso")
        void deveExcluirAcessoComSucesso() throws Exception {

            // GIVEN
            Acesso acesso = new Acesso();
            acesso.setDescricao("ROLE_DELETE");
            acesso = acessoRepository.save(acesso);

            Long id = acesso.getId();

            // WHEN
            mockMvc.perform(delete("/api/v1/acesso/{id}", id))
                    .andExpect(status().isNoContent());

            // THEN
            assertFalse(acessoRepository.existsById(id));
        }

        @Test
        @DisplayName("Deve excluir um acesso via DELETE com corpo JSON")
        void deveExcluirComCorpo() throws Exception {

            Acesso acesso = new Acesso();
            acesso.setDescricao("ROLE_DELETE_TEST");
            acesso = acessoRepository.save(acesso);

            Long id = acesso.getId();

            String json = """
                { "id": %d }
            """.formatted(id);

            mockMvc.perform(delete("/api/v1/acesso")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    .andExpect(status().isNoContent());

            assertFalse(acessoRepository.existsById(id));
        }
    }

    }


    @DisplayName("Então retornar erro")
    @Nested
    class Falha {

    }

