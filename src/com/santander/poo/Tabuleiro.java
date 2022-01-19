package com.santander.poo;

public class Tabuleiro {

    //atributos
    private char[][] mar;


    //construtor
    public Tabuleiro(){
        mar = new char [5][5];
        for (int i = 0; i < mar.length; i++) {

            for (int j = 0; j < mar[i].length; j++) {
                mar[i][j] = SimboloTabuleiro.VAZIO.getValor();
            };
        }
    }



    //métodos
    public String desenhar() {

        var desenho = new StringBuilder("  ║");
        var divisor = new StringBuilder("═══");
        for (int cont = 0; cont < mar.length; cont++) {
            divisor.append("════");
        }
        divisor.append("\n");

        for (int cont = 0; cont < mar.length; cont++) {
            desenho.append(" ");
            desenho.append(cont);
            desenho.append(" |");
        }
        desenho.append("\n");
        desenho.append(divisor);


       return desenho.toString();
    }

}
