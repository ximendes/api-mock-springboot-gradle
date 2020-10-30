package com.mocktransactions.app.service.usuario;

import com.mocktransactions.app.entity.Usuario;
import com.mocktransactions.app.repository.usuario.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class UsuarioServiceImplTest {

    public UsuarioService service;

    @BeforeEach
    public void setUp() {
        UsuarioRepository repository = mock(UsuarioRepository.class);
        service = new UsuarioServiceImpl(repository);

        when(repository.findById(1000L)).thenReturn(Optional.of(new Usuario(1000L)));
    }

    @Test
    public void findById_DeveRetonar_UsuarioId1000() {
        Usuario usuario = service.findById(1000L)
                                 .orElse(null);
        assertNotNull(usuario, "usuário não pode ser null");
        assertEquals(1000L, usuario.getId(), "usuário deve ter id 1000");
    }

    @Test
    public void findById_NaoDeveRetonar_UsuarioId1001() {
        Usuario usuario = service.findById(1001L)
                                 .orElse(null);
        assertNull(usuario, "usuário deve ser null");
    }
}