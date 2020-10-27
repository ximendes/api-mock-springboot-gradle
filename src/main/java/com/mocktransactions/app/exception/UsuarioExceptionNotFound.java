package com.mocktransactions.app.exception;

public class UsuarioExceptionNotFound extends RuntimeException {

    public UsuarioExceptionNotFound(Long id) {
        super("Usuário com o id " + id +" não encontrado");
    }
}
