package com.mocktransactions.app.mapper;

import com.mocktransactions.app.entity.Transacao;
import com.mocktransactions.app.dto.TransacaoDto;

import java.time.ZoneOffset;

public class TransacaoMapper {

    public static TransacaoDto toDto(Transacao transacao){
        return TransacaoDto.builder()
                           .descricao(transacao.getDescricao())
                           .data(transacao.getData().toEpochSecond(ZoneOffset.UTC))
                           .valor(transacao.getValor())
                           .duplicated(transacao.isDuplicated())
                           .build();
    }
}
