package com.mocktransactions.app.service.transacao;

import com.mocktransactions.app.dto.TransacaoDto;
import com.mocktransactions.app.entity.Transacao;
import com.mocktransactions.app.mapper.TransacaoMapper;
import com.mocktransactions.app.repository.transacoes.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransacaoServiceImpl implements TransacaoService {

    private final TransacaoRepository repository;

    @Override
    public List<TransacaoDto> find(Long idUsuario, int ano, int mes) {
        return repository.findAllByIdUsuario(idUsuario)
                         .stream()
                         .filter(transacao -> filterTransacao(ano, mes, transacao))
                         .map(TransacaoMapper::toDto)
                         .collect(Collectors.toList());
    }

    private boolean filterTransacao(int ano, int mes, Transacao transacao) {
        return ano == transacao.getAno() &&
               mes == transacao.getMes();
    }

}
