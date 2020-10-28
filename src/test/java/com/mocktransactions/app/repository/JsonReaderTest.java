package com.mocktransactions.app.repository;

import com.mocktransactions.app.entity.Transacao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JsonReaderTest {

    @Test
    public void deveRetornarUsuarioTest(){
        assertNotNull(JsonReader.readUsuarioJson());
    }

    @Test
    public void deveRetornarTransacoesTest(){
        List<Transacao> transacoes = JsonReader.readTransacoesJson();
        assertNotNull(transacoes);
        assertFalse(transacoes.isEmpty());
        assertEquals(18, transacoes.size());
    }
}