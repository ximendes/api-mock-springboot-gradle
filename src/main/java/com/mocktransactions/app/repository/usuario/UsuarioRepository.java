package com.mocktransactions.app.repository.usuario;

import com.mocktransactions.app.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository {

    Optional<Usuario> findById(Long id);
}
