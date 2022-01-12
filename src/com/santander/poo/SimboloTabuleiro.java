package com.santander.poo;

public enum SimboloTabuleiro {

    VAZIO('~'),
    NAVIO_INTEIRO('#'),
    NAVIO_ATINGIDO('X'),
    TIRO_ERRADO('^');

    public char valor;

    SimboloMar(char valor) {
        this.valor = valor;

    }
}
