package com.mocktransactions.app.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mocktransactions.app.entity.Transacao;
import com.mocktransactions.app.entity.Usuario;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.databind.DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE;

public class JsonReader {

    private static final String TRANSACOES_JSON = "/json/transacoes.json";
    private static final String USUARIO_JSON = "/json/usuario.json";

    public static Usuario readUsuarioJson() {
        Usuario usuario = new Usuario();
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
        mapper.registerModule(new JavaTimeModule());
        TypeReference<Usuario> typeReference = new TypeReference<Usuario>() {
        };
        InputStream resourceAsStream = TypeReference.class.getResourceAsStream(USUARIO_JSON);
        try {
            usuario = mapper.readValue(resourceAsStream, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public static List<Transacao> readTransacoesJson() {
        List<Transacao> transacoes = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
        mapper.registerModule(new JavaTimeModule());
        TypeReference<List<Transacao>> typeReference = new TypeReference<List<Transacao>>() {
        };
        InputStream resourceAsStream = TypeReference.class.getResourceAsStream(TRANSACOES_JSON);
        try {
            transacoes = mapper.readValue(resourceAsStream, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transacoes;
    }

}
