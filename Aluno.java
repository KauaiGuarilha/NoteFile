package br.com.NotaFile;

public class Aluno extends Pessoa {
    
    private final static long serialVersionUID = 1;
    private String matricula, curso, disciplina;
    private int turma;
    private double nota1, nota2, nota3, media;
    Professor prof;
   
    
    
    public Aluno(String nome, String cpf,String matricula, String curso, String disciplina, int turma){
        super(nome, cpf);
        this.matricula = matricula;
        this.curso = curso;
        this.disciplina = disciplina;
        this.turma = turma;
        
        
    }
    
    public Aluno(String nome, String cpf,String matricula, String curso, String disciplina, int turma, double nota1, double nota2, double nota3){
        this(nome, cpf, matricula, curso, disciplina, turma);
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    
    
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String discpl) {
        this.disciplina = discpl;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

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

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
    
    public void calcularMedia(){
        double media1 = ((getNota1() * 0.25) + (getNota2() * 0.25));
        double mediaFinal = ((getNota3() * 0.5) + media1);
        this.media = mediaFinal;
        if(mediaFinal < 5.0){
            System.out.println("Sua média Final foi : " + this.media );
            System.out.println(getNome() + " está REPROVADO!!");
        }else if( mediaFinal >= 5.1 && mediaFinal <=7.0){
            System.out.println("Sua média Final foi: " + this.media);
            System.out.println(getNome() + " está em Recuperação!");
        }else if (mediaFinal >= 7.1){
            System.out.println("Sua média Final foi : " + this.media);
            System.out.println(getNome() + " está APROVADO !!");
        }
    }
     
    /*@Override
    public void imprimePessoa() {
        System.out.println("Professor: " + prof.getNome());
        System.out.println(" Número: "+ getNumero() +"\n Nome : " + getNome() + "\n Curso : " + getCurso() + "\n Disciplina : " + getDisciplina() + "\n Turma : " + getTurma()
                         + "\n Prova 1 : " + getNota1() + " \n Prova 2 : " + getNota2() + "\n Trabalho : " + getNota3()+"\n");
    }   */
    
    /*public void imprimeAlunoMedia() {
        System.out.println(" Número: "+ getNumero() +"\n Nome : " + getNome() + "\n Curso : " + getCurso() + "\n Disciplina : " + getDisciplina() + "\n Turma : " + getTurma()
                         + "\n Prova 1 : " + getNota1() + " \n Prova 2 : " + getNota2() + "\n Trabalho : " + getNota3()+"\n");
    }*/
    
    
}
