package com.mocktransactions.app.repository.usuario;

import com.mocktransactions.app.entity.Usuario;
import com.mocktransactions.app.repository.JsonReader;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Override
    public Optional<Usuario> findById(Long id) {
        Usuario usuario = JsonReader.readUsuarioJson();
        return usuario.getId().equals(id) ? Optional.of(usuario) : Optional.empty();
    }
}
