/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex01;

import java.util.Random;

/**
 *
 * @author anafrozza
 */
/**
 * Faça um programa que localize o maior valor em um vetor Divida o programa em
 * tarefas que localizam o maior valor em um segmento do vetor O programa deve
 * possibilitar especificar o número de tarefas e o número de threads para
 * resolver o problema.
 *
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

        MaiorValor maiorValor = new MaiorValor(vetor, 5);
        maiorValor.searchBiggerNum();
    }
}
