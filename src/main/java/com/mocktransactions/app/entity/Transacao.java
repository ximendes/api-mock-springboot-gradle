package com.mocktransactions.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transacao implements Serializable {

    private Long id;

    @Min(10)
    @Max(60)
    private String descricao;

    private Long idUsuario;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private ZonedDateTime data;

    private Integer valor;

    private boolean duplicated;

    public int getMes(){
        return this.getData().getMonth().getValue();
    }

    public int getAno(){
        return this.getData().getYear();
    }
}
