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
public class Heap implements Callable<Vetor>{
    Vetor dados;
    int[] vetor;

    public Heap(int[] vetor) {
        this.vetor = vetor;
        this.dados = new Vetor();
    }

    @Override
    public Vetor call() throws Exception {
        buildMaxHeap(vetor);
        int n = vetor.length;

        for (int i = vetor.length - 1; i > 0; i--) {
            swap(vetor, i, 0);
            maxHeapify(vetor, 0, --n);
        }

        this.dados.setNome("HeapSort");
        this.dados.setVetor(this.vetor);
        return this.dados;
    }


    private void buildMaxHeap(int[] v) {
        for (int i = v.length / 2 - 1; i >= 0; i--) {
            maxHeapify(v, i, v.length);
        }

    }

    private void maxHeapify(int[] vetor, int pos, int tamanhoDoVetor) {

        int max = 2 * pos + 1, right = max + 1;
        if (max < tamanhoDoVetor) {

            if (right < tamanhoDoVetor && vetor[max] < vetor[right]) {
                max = right;
            }

            if (vetor[max] > vetor[pos]) {
                swap(vetor, max, pos);
                maxHeapify(vetor, max, tamanhoDoVetor);
            }
        }
    }

    public void swap(int[] v, int j, int aposJ) {
        int aux = v[j];
        v[j] = v[aposJ];
        v[aposJ] = aux;
    }
}
