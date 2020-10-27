package com.mocktransactions.app.service.usuario;

import com.mocktransactions.app.entity.Usuario;
import com.mocktransactions.app.repository.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }
}
