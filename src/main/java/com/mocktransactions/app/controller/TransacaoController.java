package com.mocktransactions.app.controller;

import com.mocktransactions.app.dto.TransacaoDto;
import com.mocktransactions.app.exception.UsuarioExceptionNotFound;
import com.mocktransactions.app.service.transacao.TransacaoService;
import com.mocktransactions.app.service.usuario.UsuarioService;
import com.mocktransactions.app.validations.ValidacaoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransacaoController {

    private final TransacaoService transacaoService;
    private final UsuarioService usuarioService;

    @GetMapping("{idUsuario}/transacoes/{ano}/{mes}")
    public List<TransacaoDto> transacoes(@PathVariable Long idUsuario,
                                         @PathVariable int ano,
                                         @PathVariable int mes) {

        this.validarRequisicao(idUsuario, ano, mes);
        usuarioService.findById(idUsuario)
                      .orElseThrow(() -> new UsuarioExceptionNotFound(idUsuario));

        return transacaoService.find(idUsuario, ano, mes);
    }

    private void validarRequisicao(Long idUsuario, int ano, int mes) {
        new ValidacaoRequest().setIdUsuario(idUsuario)
                              .setMes(mes)
                              .setAno(ano)
                              .validar();
    }
}
