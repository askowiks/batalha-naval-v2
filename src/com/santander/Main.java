package com.santander;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int tamanhoTabuleiro = 5;
        int qtdNavios = 5;
        int[][] tabuleiro = new int[tamanhoTabuleiro][tamanhoTabuleiro];
        String[][] campoDeBatalha = new String[tamanhoTabuleiro][tamanhoTabuleiro];

        exibirTabuleiro(tabuleiro);
        posicionarNavio(tabuleiro, qtdNavios);
        iniciarCampoBatalha(campoDeBatalha);
        atirar(campoDeBatalha, tabuleiro, qtdNavios);
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

    public static void posicionarNavio(int[][] tabuleiro, int qtdNavios){
        Scanner entrada = new Scanner(System.in);
        int horizontal;
        int vertical;
        String posicaoLida;
        int contNavio = 1;


           do {
                 try {
                   System.out.println("\nEscolha a posição  do seu " + contNavio + "º navio (separado por \",\")");
                   posicaoLida = entrada.nextLine(); //5,9
                   var posicaoArray = posicaoLida.trim().split(",");
                   horizontal = Integer.parseInt(posicaoArray[0].trim());
                   vertical = Integer.parseInt(posicaoArray[1].trim());

                   if (horizontal >= tabuleiro.length || vertical >= tabuleiro.length) {
                       System.out.println("Posição inválida!");
                       contNavio--;
                   } else if (tabuleiro[horizontal][vertical] == 1) {
                       System.out.println("Ops, já tem um navio aqui!");
                       contNavio--;
                   } else {
                       tabuleiro[horizontal][vertical] = 1;
                       contNavio++;
                       System.out.println("Navio :" + contNavio +"/" + qtdNavios);
                   }
                   exibirTabuleiro(tabuleiro);
                 }catch (Exception e){
                   System.out.println("Posição inválida!");
                }

           }while (contNavio <= qtdNavios);
   }

    public static void iniciarCampoBatalha (String[][] campoDeBatalha){

        System.out.println(
                ".\n \n \n \n \n \n \n \n \n \n " +
                        "BEM VINDO A BATALHA NAVAL! \n"+
                        "............,|)......|_\\\n" +
                        "............/|)......|).\\\n" +
                        ".........../.|)......|)..\\\n" +
                        "........../..|)......|)...\\\n" +
                        "........./...|)......|)....\\\n" +
                        "......../....|).......|).....\\\n" +
                        "......./...,-- ---_...|.......\\\n" +
                        "....'\\==-,,;,,;,,;,,,,,,,-==;7~.~.~.~.~.~\n" +
                        "....~.\\__....__...__.....__/~.~.~.~.~.~\n" +
                        "...~.~.~.~.~.~.~.~.~.~.~.~.~r..?.\n" +
                        "\n"
        );

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
    }

    public static void exibirCampoBatalha(String[][] campoDeBatalha){
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

    public static void atirar(String[][] campoDeBatalha, int[][] tabuleiro, int qtdNavios){
        Scanner entrada = new Scanner(System.in);
        int horizontal;
        int vertical;
        String posicaoLida;
        int naviosAfundados = 0;

        do {
            try {
            System.out.println("Escolha a posição  do seu tiro (separado por \",\")");
            posicaoLida = entrada.nextLine(); //5,9
            var posicaoArray = posicaoLida.trim().split(",");
            horizontal = Integer.parseInt(posicaoArray[0].trim());
            vertical = Integer.parseInt(posicaoArray[1].trim());

            if (horizontal >= tabuleiro.length || vertical >= tabuleiro.length){
                System.out.println("Posição inválida!");
            }else if (tabuleiro[horizontal][vertical] == 1) {
                if (campoDeBatalha[horizontal][vertical] == "X"){
                    naviosAfundados--;
                    System.out.println("Você já acertou esse navio!");
                }
                campoDeBatalha[horizontal][vertical] = "X";
                naviosAfundados++;
                System.out.println("Você já atingiu " + naviosAfundados + ", faltam apenas " + (qtdNavios-naviosAfundados) + "!");
            }else{campoDeBatalha[horizontal][vertical] = "O";
                System.out.println("Ops, você errou!");
            }

            exibirCampoBatalha(campoDeBatalha);
            } catch (Exception e) {
                System.out.println("Posição inválida, digite novamente");
            }
        }while (naviosAfundados < 5);

        if (naviosAfundados == 5){
            System.out.println("PARABÉNS! VOCÊ DERRUBOU TODOS OS NAVIOS!");
        }
    }

}
