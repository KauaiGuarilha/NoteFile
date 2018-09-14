package br.com.NotaFile;

// Classe à ser implementada

public class Media {
    
    private final static long serialVersionUID = 1;
    private static int contador = 0;
    private double nota1;
    private double nota2;
    private double nota3;
    private double media;
    private int numero;
    Aluno aluno;
    
    /*public Media(double nota1,double nota2, double nota3){
        this.numero = ++contador;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
             
    }*/
    

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
}
