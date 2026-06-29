package CRUD_alunos.model;

public class Aluno {
    private int id;
    private String nome;
    private String email;
    private String curso;
    private double nota;

    public Aluno(String nome, String email, String curso, double nota) {
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.nota = nota;
    }

    public Aluno(int id, String nome, String email, String curso, double nota) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.nota = nota;
    }

    
    public void exibirAluno(){
        System.out.println("\nID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Curso: " + getCurso());
        System.out.println("Nota final: " + getNota());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
