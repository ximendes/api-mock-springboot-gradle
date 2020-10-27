package com.mocktransactions.app.repository.transacoes;

import com.mocktransactions.app.entity.Transacao;
import com.mocktransactions.app.repository.JsonReader;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransacaoRepositoryImpl implements TransacaoRepository{

    @Override
    public List<Transacao> findAllByIdUsuario(Long idUsuario) {
        return JsonReader.readTransacoesJson()
                         .stream()
                         .filter(transacao -> idUsuario.equals(transacao.getIdUsuario()))
                         .collect(Collectors.toList());
    }
}
