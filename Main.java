package br.com.NotaFile;

import corejava.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) {
        
        ListaDeObjetos listaDePessoa = null; // Tem que por null para que o compilador não apresente erro na inicialização da class, porque lista é inicializado dentro do try
        String nome, cpf;
        String matricula, curso, disciplina;
        int turma;
        double nota1, nota2, nota3, media;
        Aluno umAluno; // Classe Aluno
        Professor umProfessor = null, alunoDois;
        
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Escola\\dados.txt")); 
            listaDePessoa = (ListaDeObjetos) in.readObject(); // Garantia de que listaDeAluno realmente pertence à ListaDeObjetos
            Pessoa.setContador(((Integer) in.readObject()).intValue()); // Incrementa o índice no contador,um intValue, um valor
            in.close();
        
        } catch(FileNotFoundException e){ // Não encontrou o aquivo 
            listaDePessoa = new ListaDeObjetos(10);        
            
        } catch(IOException e){ // Erro no Disco de gravação
            e.printStackTrace();
            System.exit(2);
            
        } catch (ClassNotFoundException e){ // Não encontrou a classe informada
            e.printStackTrace();
            System.exit(3);
        }
        
        boolean continua = true;
        
            System.out.println("====================================================");
            System.out.println("================CADASTRO ESCOLAR====================");
            System.out.println("====================================================");
        
        
        while(continua){
            
            System.out.println('\n' + "====================================================");
            System.out.println("                                                    ");
            System.out.println('\n' + "1. Cadastrar um Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Remover um Aluno");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Sair");
            
            int opcao = Console1.readInt('\n' + " Digite um número entre 1 e 5 : ");
            
            switch(opcao){
                
                case 1: {
                    
                    nome = Console1.readLine('\n' + " Informe o nome do Aluno : ");
                    cpf = Console1.readLine(" Informe o CPF do Aluno: ");
                    matricula = Console1.readLine(" Informe o número da Matricula: ");
                    curso = Console1.readLine(" Informe o nome do Curso: ");
                    disciplina = Console1.readLine(" Informe a Discliplina: ");
                    turma = Console1.readInt(" Informe o número da Turma: ");
                    nota1 = Console1.readDouble(" Informe a nota da Prova 1: ");
                    nota2 = Console1.readDouble(" Informe a nota da Prova 2: ");
                    nota3 = Console1.readDouble(" Informe a nota do Trabalho: ");
                    
                    umAluno = new Aluno(nome, cpf, matricula, curso, disciplina, turma, nota1, nota2, nota3);
                    listaDePessoa.adicionar(umAluno);
                
                    System.out.println('\n' +" Aluno Cadastrado com sucesso !!!");
                    break;
                }
                
                case 2: {
                      
                      int resposta = Console1.readInt('\n' + " Informe o número do Aluno : ");
                      
                        alunoDois = (Professor) listaDePessoa.recuperar(resposta);
                        nome = Console1.readLine("Informe o nome do Professor : ");
                        cpf = Console1.readLine("Informe o CPF do Professor: ");
                        matricula = Console1.readLine("Informe o número da Matricula: ");
                        turma = Console1.readInt("Informe o número da Turma: ");
                        
                        umProfessor = new Professor(nome, cpf, matricula, turma);
                        listaDePessoa.adicionar(umProfessor);
                        
                        System.out.println("Professor cadastrado com Sucesso !!");
                             
                        
                    break;
                }
                
                case 3:{
                    
                    int resposta = Console1.readInt('\n' + " Informe o número do Aluno que deseja Excluir: ");
                    umAluno = (Aluno) listaDePessoa.recuperarPrimeiro();
                      if(listaDePessoa.remover(resposta)){
                        
                        
                        System.out.println('\n' + "Removido com Sucesso!");
                        umAluno = (Aluno) listaDePessoa.recuperarProximo();
                       
                      }else{
                        System.out.println('\n' + "Aluno não encontrado!");
                        
                    }
                     
                }
                
                case 4: {
                    if(listaDePessoa.vazia()){
                        System.out.println('\n' + " Não há Alunos cadastrados!");
                    }else{
                        umAluno = (Aluno) listaDePessoa.recuperarPrimeiro();
                        while(umAluno != null && umProfessor != null){
                            System.out.println("__________________________________________");
                            System.out.println(" PROFESSOR: " + umProfessor.getNome());
                            System.out.println(" Número: "+ umAluno.getNumero() +"\n Nome : " + umAluno.getNome() + "\n Curso : " + umAluno.getCurso() 
                                           + "\n Disciplina : " + umAluno.getDisciplina() + "\n Turma : " + umAluno.getTurma()
                                           + "\n Prova 1 : " + umAluno.getNota1() + " \n Prova 2 : " + umAluno.getNota2() + "\n Trabalho : " + umAluno.getNota3()+"\n");
                            umAluno.calcularMedia();
                            System.out.println("__________________________________________");
                             //umAluno.imprimePessoa();
                             
                             umProfessor = (Professor) listaDePessoa.recuperarProximo();
                             umAluno = (Aluno) listaDePessoa.recuperarProximo();
                        }
                    }
                    
                    break;
                }
                
                case 5: {
                    String resposta = Console1.readLine('\n' + "Deseja salvar as alterações ? (s/n)");
                    
                    if(resposta.equals("s")){
                       try{
                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Escola\\dados.txt"));
                            out.writeObject(listaDePessoa);
                            out.writeObject(new Integer (Aluno.getContador()));
                            out.close();
                    
                        } catch (FileNotFoundException e){
                            e.printStackTrace();
                            System.exit(1);                              
                                
                        } catch (IOException e){
                            e.printStackTrace();
                            System.exit(2);
                        }
                    } else {
                        System.out.println("Os dados não foram salvos!");
                    }
                    
                    continua = false;
                    break;
                }
                
            default:
            System.out.println("Opção Inválida");
            break; 
            
            }
        }
    }
}
