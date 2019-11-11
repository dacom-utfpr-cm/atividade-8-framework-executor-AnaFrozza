/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex04;

/**
 *
 * @author anafrozza
 */
/**
 * Faça um programa que periodicamente monitore mudanças em um conjunto de
 * arquivos especificados Se ocorreram mudanças, o programa deve registrá-las em
 * um arquivo de log.
 */
public class Main {

    public static void main(String[] args) {
        Monitora monitora = new Monitora("/home/anafrozza/NetBeansProjects/ProgramacaoConcorrente/src/atividade08/ex04/ola.java");
       
        System.out.println("Concluido!");
    }

}
