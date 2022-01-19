package com.santander.poo;

public enum SimboloTabuleiro {

    VAZIO('~'),
    NAVIO_INTEIRO('#'),
    NAVIO_ATINGIDO('X'),
    TIRO_ERRADO('^');

    private char valor;

    SimboloTabuleiro(char valor) {
        this.valor = valor;

    }

    public char getValor() {
        return this.valor;
    }

}
