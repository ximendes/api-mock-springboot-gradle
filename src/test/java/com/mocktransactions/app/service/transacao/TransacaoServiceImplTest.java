package com.mocktransactions.app.service.transacao;

import com.mocktransactions.app.dto.TransacaoDto;
import com.mocktransactions.app.entity.Transacao;
import com.mocktransactions.app.repository.transacoes.TransacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
class TransacaoServiceImplTest {

    private TransacaoService service;

    @BeforeEach
    public void setUp() {
        TransacaoRepository repository = mock(TransacaoRepository.class);
        service = new TransacaoServiceImpl(repository);
        Transacao transacao = Transacao.builder()
                                       .idUsuario(1000L)
                                       .descricao("teste1")
                                       .valor(100)
                                       .data(LocalDateTime.parse("2020-10-20T06:30:00"))
                                       .build();

        when(repository.findAllByIdUsuario(1000L)).thenReturn(Collections.singletonList(transacao));
    }

    @Test
    public void find_Transacao_MesOutubro2020_Usuario1000() {
        List<TransacaoDto> transacoes = service.find(1000L, 2020, 10);
        assertNotNull(transacoes, "transações não podem ser null");
        assertEquals(1, transacoes.size(), "deve retornar apenas uma transação");
    }

    @Test
    public void find_Transacao_MesOutubro2020_Usuario2000() {
        List<TransacaoDto> transacoes = service.find(2000L, 2020, 10);
        assertNotNull(transacoes,"transações não podem ser null");
        assertTrue(transacoes.isEmpty(), "transações devem ser vazias");
    }
}