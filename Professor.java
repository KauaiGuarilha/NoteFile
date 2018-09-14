package br.com.NotaFile;

public class Professor extends Pessoa {
    
    private final static long serialVersionUID = 1;
    private String matricula;
    private int turma;
    private Aluno alunoDois;
    
    public Professor(String nome, String cpf, String matricula, int turma){
        super(nome, cpf);
        this.matricula = matricula;
        this.turma = turma;
    }  
    public Professor(String nome, String cpf, String matricula, int turma, Aluno alunoDois){
        this(nome, cpf, matricula, turma);
        this.alunoDois = alunoDois;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }
    
    public void setAluno(Aluno a){
        alunoDois = a;
    }
    
    public String getAluno(){
        return alunoDois.getNome();
    }
    

    @Override
    public void imprimePessoa() {
        
    }
    
    
}
