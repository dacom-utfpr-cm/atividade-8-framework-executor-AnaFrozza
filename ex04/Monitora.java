/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex04;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author anafrozza
 */
public class Monitora {
    private final ScheduledExecutorService executor;
    private final ScheduledFuture future;
    private final Tarefa tarefa;
    private String nao_mudou;
    private String mudou;



    public Monitora(String local) {
        this.executor = Executors.newScheduledThreadPool(1);
        this.tarefa = new Tarefa(local, this);

        this.future = this.executor.scheduleAtFixedRate(this.tarefa, 3, 2, TimeUnit.SECONDS);
    }

    
    public String getNao_mudou() {
        return nao_mudou;
    }

    public void setNao_mudou(String nao_mudou) {
        this.nao_mudou = nao_mudou;
    }

    public String getMudou() {
        return mudou;
    }

    public void setMudou(String mudou) {
        this.mudou = mudou;
    }

}
