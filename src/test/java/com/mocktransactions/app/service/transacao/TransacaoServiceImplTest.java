package com.mocktransactions.app.service.transacao;

import com.mocktransactions.app.dto.TransacaoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TransacaoServiceImplTest {

    @Autowired
    public TransacaoServiceImpl service;

    @Test
    public void deveRetornarUmaTransacao(){
        List<TransacaoDto> transacoes = service.find(1000L, 2020, 10);
        assertNotNull(transacoes);
        assertEquals(1, transacoes.size());
    }

    @Test
    public void naoDeveRetornarTransacoes(){
        List<TransacaoDto> transacoes = service.find(2000L, 2020, 10);
        assertNotNull(transacoes);
        assertEquals(0, transacoes.size());
    }

    @Test
    public void deveRetornarTransacoesDuplicadaJaneiro(){
        List<TransacaoDto> transacoes = service.find(1000L, 2020, 1);
        assertNotNull(transacoes);
        assertEquals(2, transacoes.size());
        assertEquals(1, transacoes.stream().filter(TransacaoDto::isDuplicated).count());
        assertEquals(1, transacoes.stream().filter(t -> !t.isDuplicated()).count());
    }

    @Test
    public void deveRetornarTransacoesDuplicadaFeveiro(){
        List<TransacaoDto> transacoes = service.find(1000L, 2020, 2);
        assertNotNull(transacoes);
        assertEquals(3, transacoes.size());
        assertEquals(1, transacoes.stream().filter(TransacaoDto::isDuplicated).count());
        assertEquals(2, transacoes.stream().filter(t -> !t.isDuplicated()).count());
    }

    @Test
    public void deveRetornarTransacoesDuplicadaDezembro(){
        List<TransacaoDto> transacoes = service.find(1000L, 2020, 12);
        assertNotNull(transacoes);
        assertEquals(2, transacoes.size());
        assertEquals(1, transacoes.stream().filter(TransacaoDto::isDuplicated).count());
        assertEquals(1, transacoes.stream().filter(t -> !t.isDuplicated()).count());
    }
}