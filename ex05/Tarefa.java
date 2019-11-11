/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex05;

/**
 *
 * @author anafrozza
 */
public class Tarefa implements Runnable {

    @Override
    public void run() {
        int x = 0;
        int tam = 5;

        while (x < tam) {
            try {
                System.out.println("Não faz nada...");
                x++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Erro: "+e);
            }
        }

        System.out.println("Fim Tarefa!");

    }
}
