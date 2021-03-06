package com.mocktransactions.app.validations;

import com.mocktransactions.app.exception.ValidacaoException;

public class ValidacaoRequest {

    private Long idUsuario;
    private int mes;
    private int ano;

    public ValidacaoRequest setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public ValidacaoRequest setMes(int mes) {
        this.mes = mes;
        return this;
    }

    public ValidacaoRequest setAno(int ano) {
        this.ano = ano;
        return this;
    }

    public void validar() {
        this.validarId();
        this.validarMes();
        this.validarAno();
    }

    private void validarId() {
        if (this.idUsuario < 1000 || this.idUsuario > 100000000) {
            exception("informe um id de usuário entre 1.000 e 100.000.000");
        }
    }

    private void validarMes() {
        if (this.mes < 1 || this.mes > 12) {
            exception("informe um mês de 1 a 12");
        }
    }

    private void validarAno() {
        if (this.ano < 1) {
            exception("informe um ano válido");
        }
    }

    private void exception(String mensagem) {
        throw new ValidacaoException(mensagem);
    }
}
