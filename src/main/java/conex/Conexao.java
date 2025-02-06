package conex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//classe que vai fazer a conexão com o banco de dados

public class Conexao {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/banco";
    private static final String user = "root";
    private static final String password = "senha123";

    private static Connection conn;

    public static Connection getConexao() {

        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
