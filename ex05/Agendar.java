/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex05;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author anafrozza
 */
public class Agendar {
    ScheduledExecutorService executor;
    ScheduledFuture future;
    int tempo;
    Tarefa tarefa;

    public Agendar(int tempo) {
        this.tempo = tempo;
        this.executor = Executors.newScheduledThreadPool(1);
        this.tarefa = new Tarefa();

        System.out.println("Tarefa agendada para daqui "+tempo+"s");
        this.future = this.executor.schedule(this.tarefa, tempo, TimeUnit.SECONDS);

        while (!this.future.isDone()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Erro: "+e);
            }
        }

        System.out.println("Fim Principal");
        this.executor.shutdown();
    }

}
