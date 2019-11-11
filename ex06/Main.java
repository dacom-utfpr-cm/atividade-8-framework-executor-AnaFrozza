/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex06;

import java.util.Random;

/**
 *
 * @author anafrozza
 */
/**
 * Faça um programa que execute três algoritmos de ordenação para um conjunto de
 * valores e exiba o resultado apenas do algoritmo que finalizar primeiro (use
 * invokeAny ).
 */

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        //Inicializar vetor
        int tam = 10;
        int[] vetor = new int[tam];

        for (int i = 0; i < tam; i++) {
            vetor[i] = random.nextInt(20);
        }

        Ordenar ordenar = new Ordenar(vetor);
        ordenar.init();
        
        System.out.println("Concluido!");
    }
}
