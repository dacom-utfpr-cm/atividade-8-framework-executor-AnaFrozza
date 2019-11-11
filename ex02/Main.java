/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex02;

import java.util.Random;

/**
 *
 * @author anafrozza
 */
/**
 * Faça um programa que calcule a soma dos elementos de uma matriz MxN Divida o
 * programa em tarefas que somam as linhas O programa deve possibilitar
 * especificar o número de threads para resolver o problema.
 */
public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        
        //Inicializar matriz
        int x = 5;
        int y = 5;
        int[][] matriz = new int[y][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matriz[i][j] = random.nextInt(10);
            }
        }

        SomaValores soma = new SomaValores(matriz, 5, x, y);
        soma.sumMatriz();
    }
}
