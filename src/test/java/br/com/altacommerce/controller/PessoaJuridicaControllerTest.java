package br.com.altacommerce.controller;

import br.com.altacommerce.dto.response.PessoaJuridicaResponseDTO;
import br.com.altacommerce.model.enums.TipoPessoa;
import br.com.altacommerce.service.PessoaJuridicaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PessoaJuridicaController.class)
@AutoConfigureMockMvc(addFilters = false)
class PessoaJuridicaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PessoaJuridicaService pessoaJuridicaService;

    @Test
    @DisplayName("Deve cadastrar Pessoa Jurídica com sucesso (mockado)")
    void deveCadastrarPessoaJuridicaComSucesso() throws Exception {

        String json = """
        {
          "nome": "Metalúrgica Força Total S.A.",
          "email": "comercial@forcatotal.ind.br",
          "telefone": "+55 19 3888-9999",
          "cnpj": "23.456.789/0001-10",
          "nomeFantasia": "Força Metal"
        }
        """;

        PessoaJuridicaResponseDTO response =
                new PessoaJuridicaResponseDTO(
                        1L,
                        "Metalúrgica Força Total S.A.",
                        "comercial@forcatotal.ind.br",
                        "+55 19 3888-9999",
                        TipoPessoa.JURIDICA,
                        List.of(), // endereços mockados
                        "23.456.789/0001-10",
                        "456.789.012.345",
                        "1098765-4",
                        "Força Metal",
                        "Força Total Componentes Industriais Ltda.",
                        "Indústria e Manufatura"
                );

        when(pessoaJuridicaService.createPessoaJuridica(any()))
                .thenReturn(response);

        mockMvc.perform(post("/api/v1/pessoa-juridica")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nome").value("Metalúrgica Força Total S.A."))
                .andExpect(jsonPath("$.email").value("comercial@forcatotal.ind.br"))
                .andExpect(jsonPath("$.telefone").value("+55 19 3888-9999"))
                .andExpect(jsonPath("$.tipoPessoa").value("JURIDICA"))
                .andExpect(jsonPath("$.cnpj").value("23.456.789/0001-10"))
                .andExpect(jsonPath("$.nomeFantasia").value("Força Metal"));
    }
}

