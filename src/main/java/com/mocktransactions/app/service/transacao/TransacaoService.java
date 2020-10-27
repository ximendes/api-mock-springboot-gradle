package com.mocktransactions.app.service.transacao;

import com.mocktransactions.app.dto.TransacaoDto;

import java.util.List;

public interface TransacaoService {

    List<TransacaoDto> find(Long idUsuario, int ano, int mes);
}
