package CRUD_alunos.dao;

import CRUD_alunos.db.ConexaoDB;
import CRUD_alunos.model.Aluno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    public boolean inserir(Aluno aluno){
        String sql = "INSERT INTO alunos (nome, email, curso, nota) VALUES (?, ?, ?, ?)";

        try(Connection connection = ConexaoDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getEmail());
            ps.setString(3, aluno.getCurso());
            ps.setDouble(4, aluno.getNota());

            int linhasAfetadas = ps.executeUpdate();

            return linhasAfetadas > 0;
        }catch(SQLException erro){
            System.out.println("\nErro ao inserir aluno: " + erro.getMessage());
            return false;
        }
    }

    public boolean deletar(int id){
        String sql = "DELETE FROM alunos WHERE id = ?";

        try(Connection connection = ConexaoDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        }catch(SQLException erro){
            System.out.println("\nErro ao deletar aluno: " + erro.getMessage());
            return false;
        }
    }

    public boolean atualizar(Aluno aluno){
        String sql = "UPDATE alunos SET nome = ?, email = ?, curso = ?, nota = ? WHERE id = ?";

        try(Connection connection = ConexaoDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getEmail());
            ps.setString(3, aluno.getCurso());
            ps.setDouble(4, aluno.getNota());

            ps.setInt(5, aluno.getId());

            return ps.executeUpdate() > 0;
        }catch(SQLException erro){
            System.out.println("\nErro ao atualizar aluno: " + erro.getMessage());
            return false;
        }
    }

    public Aluno buscarPorId(int id){
        String sql = "SELECT id, nome, email, curso, nota FROM alunos WHERE id = ?";

        try(Connection connection = ConexaoDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("curso"),
                        rs.getDouble("nota")
                    );
                }
            }
        }catch(SQLException erro){
                System.out.println("\nErro ao buscar aluno: " + erro.getMessage());
            }

            return null;
    }

    public List<Aluno> listarTodos(){
        String sql = "SELECT id, nome, email, curso, nota FROM alunos ORDER BY id";

        List<Aluno> lista = new ArrayList<>();

        try(Connection connection = ConexaoDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Aluno a = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("curso"),
                        rs.getDouble("nota")
                );

                lista.add(a);
            }
        }catch(SQLException erro){
            System.out.println("\nErro ao listar alunos: " + erro.getMessage());
        }

        return lista;
    }
}
