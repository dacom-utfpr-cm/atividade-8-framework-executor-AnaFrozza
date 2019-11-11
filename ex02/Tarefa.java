/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex02;

import java.util.concurrent.Callable;

/**
 *
 * @author anafrozza
 */
public class Tarefa implements Callable<Integer> {

    int linha;
    int tam;
    int[][] matriz;

    public Tarefa(int linha, int tam, int[][] matriz) {
        this.linha = linha;
        this.tam = tam;
        this.matriz = matriz;
    }

    @Override
    public Integer call() throws Exception {
        int soma = 0;

        for (int i = 0; i < this.tam; i++) {
            soma += this.matriz[this.linha][i];
        }

        return soma;
    }
}
