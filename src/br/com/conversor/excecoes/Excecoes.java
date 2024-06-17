package br.com.conversor.excecoes;

public class Excecoes {
    public static void handle(Exception e){
        System.out.println("Ocorreu um erro: " + e.getMessage());
    }
}
