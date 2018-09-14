package br.com.NotaFile;

import java.io.*;
import java.util.*;

public class ListaDeObjetos implements Serializable {
    
    private final static long serialVersionUID = 1;
    private ArrayList<Object> lista;
    private int corrente = -1;
    
    public ListaDeObjetos(int tam){
        lista = new ArrayList<Object>(tam);
    }
    
    public boolean adicionar(Object obj){
        return lista.add(obj);
    }
    public int tamanho(){
        return lista.size();
    }
    public boolean remover(int numero){
        int i = localizar(numero);
        if (i != -1){
            lista.remove(i);
            return true;
        }
        return false;
    }
    public Object recuperar(int numero){
        int i = localizar(numero);
        if (i != -1){
            lista.get(i);
        }
        return null;
    }
    public boolean vazia(){
        return lista.isEmpty();
    }
    public int localizar(int numero){
        Object obj = new Integer(numero);
        for(int i = 0;  i <lista.size(); i++){
            if((lista.get(i)).equals(obj)){
                return i;
            }
        }
        return -1;
    }
    public Object recuperarPrimeiro() {
        if (lista.isEmpty()) {
            return null;
        } else {
            corrente = 0;
            return lista.get(0);
        }
    }

    public Object recuperarProximo() {
        if (corrente == -1) {
            throw new ArrayIndexOutOfBoundsException("Fora dos Limites do ArrayList");
        } else {
            corrente++;
            if (corrente < lista.size()) {
                return lista.get(corrente);
            } else {
                corrente = -1;
                return null;
            }
        }
   }
}
