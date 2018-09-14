package br.com.NotaFile;

import java.io.*;

public abstract class Pessoa implements Serializable {
    
    private final static long serialVersionUID = 1;
    private static int contador = 0;
    private int numero;
    private String nome, cpf;
    
    public Pessoa(String nome, String cpf){
        this.numero = ++contador;
        this.nome = nome;
        this.cpf = cpf;
    }    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Pessoa.contador = contador;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
        
    public void imprimePessoa(){
    
    } 
    
}
