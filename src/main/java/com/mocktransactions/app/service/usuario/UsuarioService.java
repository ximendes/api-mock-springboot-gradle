package com.mocktransactions.app.service.usuario;

import com.mocktransactions.app.entity.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> findById(Long id);
}
