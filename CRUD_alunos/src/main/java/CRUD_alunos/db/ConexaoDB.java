package CRUD_alunos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String URL  = "";//Insira sua URL aqui
    private static final String USER = "";//Insira seu usuario aqui
    private static final String PASS = "";//Insira sua senha aqui

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
