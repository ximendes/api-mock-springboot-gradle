package com.mocktransactions.app.repository.transacoes;

import com.mocktransactions.app.entity.Transacao;

import java.util.List;

public interface TransacaoRepository {

    List<Transacao> findAllByIdUsuario(Long idUsuario);
}
