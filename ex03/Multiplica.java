/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex03;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author anafrozza
 */
public class Multiplica {
    int[][] matriz01;
    int[][] matriz02;
    int tam;
    ArrayList<Future<Integer>> matrixResultado;
    ExecutorService thread;

    public Multiplica(int[][] matriz01, int[][] matriz02, int tam) {
        this.matriz01 = matriz01;
        this.matriz02 = matriz02;
        this.tam = tam;

        this.thread = Executors.newFixedThreadPool(tam);
        this.matrixResultado = new ArrayList<>();
    }

    public void multiplicaMatriz() {

        System.out.println("Inicializando Tarefas ...");
        for (int i = 0; i < this.tam; i++) {
            for (int j = 0; j < this.tam; j++) {

                Tarefa tarefa = new Tarefa(this.matriz01, this.matriz02, i, j, this.tam);

                Future<Integer> resultado = this.thread.submit(tarefa);
                this.matrixResultado.add(resultado);
            }
        }

        System.out.println("Matriz Resultado: ");
        int count = 0;
        for(Future<Integer> tarefa : this.matrixResultado){
            try {
                System.out.print(" "+tarefa.get());
                count++;
                if(count >= this.tam){
                    System.out.println();
                    count=0;
                }

            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Erro: "+e);
            }
        }

        this.thread.shutdown();
    }

}
