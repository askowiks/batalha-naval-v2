package com.santander;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int tamanhoTabuleiro = 5;
        int[][] tabuleiro = new int[tamanhoTabuleiro][tamanhoTabuleiro];


        exibirTabuleiro(tabuleiro);
        posicionarNavio(tabuleiro);

//
        //Limpar console e exibir apenas o tabuleiro de batalha (imprimir intervalo)

        String[][] campoDeBatalha = new String[tamanhoTabuleiro][tamanhoTabuleiro];
        System.out.println(
                "\n------------------------------------------\n" +
                "    CAMPO DE BATALHA\n"+
                "  ║ 0 | 1 | 2 | 3 | 4 |\n" +
                        "═══════════════════════"
        );

        for (int i = 0; i < campoDeBatalha.length; i++) {
            System.out.print(i + " ║");

            for (int j = 0; j < campoDeBatalha[i].length; j++) {
                campoDeBatalha[i][j] = "~";
                System.out.print(" " + campoDeBatalha[i][j] + " |");

            }System.out.print("\n");
        }

        atirar(campoDeBatalha, tabuleiro);


    }

    public static void exibirTabuleiro(int[][] tabuleiro){

        System.out.println(
             "\n__<->__ TABULEIRO __<->__\n" +
                "  ║ 0 | 1 | 2 | 3 | 4 |\n" +
                "═══════════════════════"
        );

        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print(i + " ║");

            for (int j = 0; j < tabuleiro[i].length; j++) {

                if (tabuleiro[i][j] == 0){
                    System.out.print(" ~ |");
                }else{ System.out.print("<->|");}

            }System.out.print("\n");
        }
    }

    public static void atirar(String[][] campoDeBatalha, int[][] tabuleiro){
        Scanner entrada = new Scanner(System.in);
        int horizontal;
        int vertical;
        String posicaoLida;

        for (int contTiros = 1; contTiros <= 10; contTiros++){
            System.out.println("Escolha a posição  do seu " + contTiros +"º tiro (separado por \",\" :");
            posicaoLida = entrada.nextLine(); //5,9
            var posicaoArray = posicaoLida.trim().split(",");
            horizontal = Integer.parseInt(posicaoArray[0].trim());
            vertical = Integer.parseInt(posicaoArray[1].trim());

            if (horizontal >= tabuleiro.length || vertical >= tabuleiro.length){
                System.out.println("Posição inválida!");
                contTiros--;}else if (tabuleiro[horizontal][vertical] == 1) {
                campoDeBatalha[horizontal][vertical] = "X";
            }else{campoDeBatalha[horizontal][vertical] = "O";}

            System.out.println(
                    "\n------------------------------------------\n" +
                            "    CAMPO DE BATALHA\n"+
                            "  ║ 0 | 1 | 2 | 3 | 4 |\n" +
                            "═══════════════════════"
            );

            for (int i = 0; i < campoDeBatalha.length; i++) {
                System.out.print(i + " ║");

                for (int j = 0; j < campoDeBatalha[i].length; j++) {
                    System.out.print(" " + campoDeBatalha[i][j] + " |");

                }System.out.print("\n");
            }
        }
    }

    public static void posicionarNavio(int[][] tabuleiro){
        Scanner entrada = new Scanner(System.in);
        int horizontal;
        int vertical;
        String posicaoLida;

        for (int contNavio = 1; contNavio <= 5; contNavio++){
            System.out.println("\nEscolha a posição  do seu " + contNavio +"º navio (separado por \",\" :");
            posicaoLida = entrada.nextLine(); //5,9
            var posicaoArray = posicaoLida.trim().split(",");
            horizontal = Integer.parseInt(posicaoArray[0].trim());
            vertical = Integer.parseInt(posicaoArray[1].trim());

            if (horizontal >= tabuleiro.length || vertical >= tabuleiro.length){
                System.out.println("Posição inválida!");
                contNavio--;} else if (tabuleiro[horizontal][vertical] == 1){
                System.out.println("Ops, já tem um navio aqui!");
                contNavio--;
            }else{
            tabuleiro[horizontal][vertical] = 1;}
            exibirTabuleiro(tabuleiro);
        }
    }

}
