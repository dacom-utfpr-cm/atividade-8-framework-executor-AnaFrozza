/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex01;

import java.util.concurrent.Callable;

/**
 *
 * @author anafrozza
 */
public class Tarefa implements Callable<Integer> {

    int inicio;
    int fim;
    int[] vetor;

    public Tarefa(int inicio, int fim, int[] vetor) {
        this.inicio = inicio;
        this.fim = fim;
        this.vetor = vetor;
    }

    @Override
    public Integer call() throws Exception {
        int maior = this.vetor[this.inicio];

        for (int i = (this.inicio + 1); i < this.fim; i++) {
            if (maior <= this.vetor[i]) {
                maior = this.vetor[i];
            }
        }
        return maior;
    }
}
