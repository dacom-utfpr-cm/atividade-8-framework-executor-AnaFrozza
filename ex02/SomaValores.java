/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex02;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author anafrozza
 */
public class SomaValores {
    int[][] matriz;
    int num;
    int x;
    int y;
    ArrayList<Future<Integer>> tarefas;
    ExecutorService thread;


    public SomaValores(int[][] matriz, int num, int x, int y) {
        this.matriz = matriz;
        this.num = num;
        this.tarefas = new ArrayList<>();
        this.x = x;
        this.y = y;
        this.thread = Executors.newFixedThreadPool(num);
    }

    public void sumMatriz(){
        int aux = 0;
        int soma=0;

        while(aux < this.x){
            Tarefa tarefa = new Tarefa(aux, this.y, this.matriz);
            Future<Integer> future = this.thread.submit(tarefa);

            this.tarefas.add(future);
            aux++;
        }

        for(Future<Integer> ft : this.tarefas){
            while(!ft.isDone()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Erro: "+e);
                }
            }
        }

        for(Future<Integer> ft : this.tarefas){
            try {
                soma += ft.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Erro: "+e);
            }
        }

        this.thread.shutdown();
        System.out.println("Soma Total: "+soma);

    }
}
