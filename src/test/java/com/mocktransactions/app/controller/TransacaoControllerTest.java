package com.mocktransactions.app.controller;

import com.mocktransactions.app.exception.UsuarioExceptionNotFound;
import com.mocktransactions.app.exception.ValidacaoException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TransacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void transacoes_Exception_Informando_IdUsuario_Menor1000() throws Exception {
        mockMvc.perform(get("/100/transacoes/2020/12")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isBadRequest())
               .andExpect(result -> assertTrue(result.getResolvedException() instanceof ValidacaoException))
               .andExpect(result -> assertEquals("informe um id de usuário entre 1.000 e 100.000.000", result.getResolvedException()
                                                                                                                       .getMessage()));
    }

    @Test
    public void transacoes_Exception_Informando_Ano_Zero() throws Exception {
        mockMvc.perform(get("/1000/transacoes/0/12")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isBadRequest())
               .andExpect(result -> assertTrue(result.getResolvedException() instanceof ValidacaoException))
               .andExpect(result -> assertEquals("informe um ano válido", result.getResolvedException()
                                                                                         .getMessage()));
    }

    @Test
    public void transacoes_Exception_Informando_Mes13() throws Exception {
        mockMvc.perform(get("/1000/transacoes/2020/13")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isBadRequest())
               .andExpect(result -> assertTrue(result.getResolvedException() instanceof ValidacaoException))
               .andExpect(result -> assertEquals("informe um mês de 1 a 12", result.getResolvedException()
                                                                                            .getMessage()));
    }

    @Test
    public void transacoes_Exception_Informando_UsuarioInexistente() throws Exception {
        mockMvc.perform(get("/10001/transacoes/2020/12")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isNotFound())
               .andExpect(result -> assertTrue(result.getResolvedException() instanceof UsuarioExceptionNotFound))
               .andExpect(result -> assertEquals("Usuário com o id 10001 não encontrado", result.getResolvedException()
                                                                                                         .getMessage()));
    }
}