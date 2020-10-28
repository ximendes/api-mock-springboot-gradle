package com.mocktransactions.app.entity;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transacao implements Serializable {

    private Long id;
    private String descricao;
    private Long idUsuario;
    private LocalDateTime data;
    private Integer valor;
    private boolean duplicated;

    public int getMes(){
        return this.getData().getMonth().getValue();
    }

    public int getAno(){
        return this.getData().getYear();
    }
}
