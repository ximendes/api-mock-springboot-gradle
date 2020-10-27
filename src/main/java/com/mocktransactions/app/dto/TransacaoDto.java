package com.mocktransactions.app.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransacaoDto implements Serializable {

    private String descricao;
    private Long data;
    private Integer valor;
    private boolean duplicated;
}
