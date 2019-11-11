/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex03;

import java.util.concurrent.Callable;

/**
 *
 * @author anafrozza
 */
public class Tarefa implements Callable<Integer>{
    int[][] matriz01;
    int[][] matriz02;
    int i;
    int j;
    int tam;

    public Tarefa(int[][] matriz01, int[][] matriz02, int i, int j, int tam) {
        this.matriz01 = matriz01;
        this.matriz02 = matriz02;
        this.i = i;
        this.j = j;
        this.tam = tam;
    }

    @Override
    public Integer call() throws Exception {
        int soma = 0;

        for (int k = 0; k < this.tam; k++) {
            soma += (this.matriz01[this.i][k] * this.matriz02[k][this.j]);
        }

        return soma;
    }
}
