package CRUD_alunos;

import CRUD_alunos.dao.AlunoDAO;
import CRUD_alunos.model.Aluno;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlunoDAO dao = new AlunoDAO();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\nSISTEMA DE ALUNOS");
            System.out.println("1 - Criar aluno");
            System.out.println("2 - Deletar aluno");
            System.out.println("3 - Atualizar aluno");
            System.out.println("4 - Buscar por ID");
            System.out.println("5 - Listar todos");
            System.out.println("0 - Sair");
            System.out.print("\nOpção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){
                case 1:
                    System.out.print("\nNome: ");
                    String nome = sc.nextLine();
                    System.out.print("\nEmail: ");
                    String email = sc.nextLine();
                    System.out.print("\nCurso: ");
                    String curso = sc.nextLine();
                    System.out.print("\nNota final: ");
                    double nota = sc.nextDouble();
                    sc.nextLine();

                    Aluno novo = new Aluno(nome, email, curso, nota);

                    boolean ok = dao.inserir(novo);
                    System.out.println(ok ? "\nAluno Criado com sucesso!" : "\nErro ao inserir aluno");
                    break;
                case 2:
                    System.out.println("\nInsira o ID do aluno que deseja deletar: ");
                    int idDeletar = sc.nextInt();
                    sc.nextLine();
                    System.out.println(dao.deletar(idDeletar) ? "\nAluno deletado com sucesso!" : "\nErro ao deletar aluno");
                    break;
                case 3:
                    System.out.println("\nInsira o ID do aluno que deseja atualizar: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();

                    Aluno aluno = dao.buscarPorId(idAtualizar);

                    if(aluno == null){
                        System.out.println("\nAluno não encontrado");
                        break;
                    }

                    System.out.print("\nNovo nome:  "); aluno.setNome(sc.nextLine());
                    System.out.print("\nNovo email: "); aluno.setEmail(sc.nextLine());
                    System.out.print("\nNovo curso: "); aluno.setCurso(sc.nextLine());
                    System.out.print("\nNova nota final:  "); aluno.setNota(sc.nextDouble());
                    sc.nextLine();
                    System.out.println(dao.atualizar(aluno) ? "\nAluno atualizado com sucesso!" : "\nErro ao atualizar aluno");
                    break;
                case 4:
                    System.out.print("\nInsira o ID do aluno que deseja buscar: ");
                    int idBuscar = sc.nextInt();
                    sc.nextLine();

                    Aluno encontrado = dao.buscarPorId(idBuscar);

                    if(encontrado != null) {
                        System.out.println(encontrado);
                    }else{
                        System.out.println("\nAluno não encontrado");
                    }
                    break;
                case 5:
                    List<Aluno> alunos = dao.listarTodos();

                    System.out.println("\nAlunos cadastrados:");
                    if(alunos.isEmpty()){
                        System.out.println("\nNenhum aluno cadastrado.");
                    }else{
                        for(Aluno a : alunos){
                            a.exibirAluno();
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nInsira uma opção válida!");
            }
        }while(opcao != 0);
        sc.close();
    }
}
