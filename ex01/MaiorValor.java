/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex01;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author anafrozza
 */
public class MaiorValor {

    int[] vetor;
    int num;

    ArrayList<Future<Integer>> tarefas;
    ExecutorService thread;

    public MaiorValor(int[] vetor, int num) {
        this.vetor = vetor;
        this.num = num;

        this.tarefas = new ArrayList<>();
        this.thread = Executors.newFixedThreadPool(num);

    }

    public void searchBiggerNum() {
        int inicio = 0;
        int fim = this.vetor.length / this.num;

        while (fim <= this.vetor.length) {
            Tarefa tarefa = new Tarefa(inicio, fim, this.vetor);

            Future<Integer> future = this.thread.submit(tarefa);
            this.tarefas.add(future);

            inicio = fim;
            fim += fim;
        }

        System.out.println("Executando ...");
        for (Future<Integer> ft : this.tarefas) {
            while (!ft.isDone()) {
                System.out.print(".");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Erro: "+e);
                }
            }
            System.out.println("");
        }

        int maiorValor;
        try {
            maiorValor = this.tarefas.get(0).get();
            for (Future<Integer> ft : this.tarefas) {
                if (maiorValor < ft.get()) {
                    maiorValor = ft.get();
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            maiorValor = -1;
            System.out.println("Erro: "+e);
        }
        System.out.println("Maior Valor: " + maiorValor);
        this.thread.shutdown();
    }
}
