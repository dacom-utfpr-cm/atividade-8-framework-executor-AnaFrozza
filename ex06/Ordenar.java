/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author anafrozza
 */
public class Ordenar {
    Collection<Callable<Vetor>> tarefas;

    ExecutorService thread;
    int[] vetor;

    public Ordenar(int[] vetor) {
        this.tarefas = new ArrayList<>();
        this.thread = Executors.newFixedThreadPool(3);
        this.vetor = vetor;
    }

    public void init() {
        Bubble bubb = new Bubble(this.vetor);
        Heap heap = new Heap(this.vetor);
        Quick quick = new Quick(this.vetor);

        this.tarefas.add(bubb);
        this.tarefas.add(heap);
        this.tarefas.add(quick);

        Vetor dados = null;

        while (dados == null) {
            try {
                dados = this.thread.invokeAny(this.tarefas);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Erro: "+e);
            }
        }

        System.out.println("Uma Tarefa Concluida!");
        System.out.println("Tipo da Busca: " + dados.getNome());

        for (int i = 0; i < dados.getVetor().length; i++) {
            System.out.print(" " + dados.getVetor()[i]);
        }
        System.out.println("");

        this.thread.shutdown();
    }
}
