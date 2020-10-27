package com.mocktransactions.app.service.usuario;

import com.mocktransactions.app.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsuarioServiceImplTest {

    @Autowired
    public UsuarioServiceImpl service;

    @Test
    public void deveRetornarUsuario(){
        Usuario usuario = service.findById(1000L)
                                 .orElse(null);
        assertNotNull(usuario);
        assertEquals(1000L, usuario.getId());
    }

    @Test
    public void naoDeveRetornarUsuario(){
        Usuario usuario = service.findById(1001L)
                                 .orElse(null);
        assertNull(usuario);
    }
}