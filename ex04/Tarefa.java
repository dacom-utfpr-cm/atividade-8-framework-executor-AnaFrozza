/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade08.ex04;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author anafrozza
 */
public class Tarefa implements Runnable{
    String local;
    MessageDigest mensagem;
    FileReader file;
    Monitora monitora;


    public Tarefa(String local, Monitora monitora) {
        this.monitora = monitora;
        this.local = local;
        try {
            this.mensagem = MessageDigest.getInstance("Ola");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro: "+e);
        }
    }

    @Override
    public void run() {
        String dados;

        try {
            dados = new String(Files.readAllBytes(Paths.get(this.local)));
        } catch (IOException e) {
            dados = " ";
            System.out.println("Erro: "+e);
        }

        System.out.println("Lendo Arquivo....");
        this.mensagem.update(dados.getBytes());
        byte[] digest = this.mensagem.digest();


        this.monitora.setMudou(DatatypeConverter.printHexBinary(digest).toUpperCase());
        System.out.println("Ola: "+DatatypeConverter.printHexBinary(digest).toUpperCase());


        if(this.monitora.getMudou().equals(this.monitora.getNao_mudou())){
            System.out.println("Houve Mudança!");
        }
        else{
            System.out.println("Nada Mudou....");
            this.monitora.setNao_mudou(DatatypeConverter.printHexBinary(digest).toUpperCase());
        }
    }
}
