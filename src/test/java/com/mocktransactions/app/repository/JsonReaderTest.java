package com.mocktransactions.app.repository;

import com.mocktransactions.app.dto.TransacaoDto;
import com.mocktransactions.app.entity.Transacao;
import com.mocktransactions.app.entity.Usuario;
import com.mocktransactions.app.mapper.TransacaoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JsonReaderTest {

    private List<Transacao> transacoes;

    @BeforeEach
    public void setUp() {
        transacoes = JsonReader.readTransacoesJson();
    }

    @Test
    public void readUsuarioJson_DeveRetonar_UsuarioId1000() {
        Usuario usuario = JsonReader.readUsuarioJson();
        assertNotNull(usuario, "usuario não deve ser null");
        assertEquals(1000L, usuario.getId(), "id usuário deve ser 1000");
    }

    @Test
    public void readTransacoesJson_DeveRetornar_18Transacoes() {
        assertNotNull(transacoes, "transações não podem ser null");
        assertFalse(transacoes.isEmpty(), "transações não podem ser vazias");
        assertEquals(18, transacoes.size(), "quantidade de transações deve ser 18");
    }

    @Test
    public void readTransacoesJson_DeveRetornar_1TransacaoDuplicada_E1TransacaoNaoDuplicada_MesJaneiro_Usuario1000() {
        List<TransacaoDto> transacaoDtos = filterTransacoesBy(1000L, 2020, 1);

        assertNotNull(transacaoDtos, "transações não podem ser null");
        assertEquals(2, transacaoDtos.size(), "quantidade de transacoes deve ser 2");

        assertEquals(1, transacaoDtos.stream()
                                     .filter(TransacaoDto::isDuplicated)
                                     .count(), "deve ter 1 transacao duplicada");

        assertEquals(1, transacaoDtos.stream()
                                     .filter(t -> !t.isDuplicated())
                                     .count(), "deve ter 1 transacao não duplicada");
    }

    @Test
    public void readTransacoesJson_DeveRetornar_1TransacaoDuplicada_E2TransacoesNaoDuplicadas_MesFevereiro_Usuario1000() {
        List<TransacaoDto> transacoes = filterTransacoesBy(1000L, 2020, 2);

        assertNotNull(transacoes, "transações não podem ser null");
        assertEquals(3, transacoes.size(), "quantidade de transacoes deve ser 2");

        assertEquals(1, transacoes.stream()
                                  .filter(TransacaoDto::isDuplicated)
                                  .count(), "deve ter 1 transacao duplicada");

        assertEquals(2, transacoes.stream()
                                  .filter(t -> !t.isDuplicated())
                                  .count(), "deve ter 2 transacoes não duplicadas");
    }

    @Test
    public void readTransacoesJson_DeveRetornar_1TransacaoDuplicada_E1TransacoesNaoDuplicadas_MesDezembro_Usuario1000() {
        List<TransacaoDto> transacoes = filterTransacoesBy(1000L, 2020, 12);

        assertNotNull(transacoes, "transações não podem ser null");
        assertEquals(2, transacoes.size(), "quantidade de transacoes deve ser 2");

        assertEquals(1, transacoes.stream()
                                  .filter(TransacaoDto::isDuplicated)
                                  .count(), "deve ter 1 transacao duplicada");

        assertEquals(1, transacoes.stream()
                                  .filter(t -> !t.isDuplicated())
                                  .count(), "deve ter 1 transacao não duplicada");
    }

    public List<TransacaoDto> filterTransacoesBy(Long idUsuario, int ano, int mes) {
        return transacoes.stream()
                         .filter(transacao ->
                                 idUsuario.equals(transacao.getIdUsuario()) &&
                                         ano == transacao.getAno() &&
                                         mes == transacao.getMes())
                         .map(TransacaoMapper::toDto)
                         .collect(Collectors.toList());
    }


}