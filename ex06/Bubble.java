/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex06;

import java.util.concurrent.Callable;

/**
 *
 * @author anafrozza
 */
public class Bubble implements Callable<Vetor>{
    Vetor dados;
    int[] vetor;


    public Bubble(int[] vetor) {
        this.dados = new Vetor();
        this.vetor = vetor;
    }

    @Override
    public Vetor call() throws Exception {

        for (int i = vetor.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (vetor[j - 1] > vetor[j]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j - 1];
                    vetor[j - 1] = aux;
                }
            }
        }

        this.dados.setNome("BubbleSort");
        this.dados.setVetor(this.vetor);
        return this.dados;
    }
}
