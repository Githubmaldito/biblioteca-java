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


        //versão antiga da conexao
        // try {
        //     if (conn == null) {
        //         conn = DriverManager.getConnection(url, user, password);
        //         return conn;
        //     } else {
        //         return conn;
        //     }
        // } catch (SQLException e) {
        //     e.printStackTrace();
        //     return null;
        // }

        try {
            //cria e retorna uma nova conexão
            //agora não verifica mais se a conexão é nula
            //(tava dando erro na listagem de usuario)
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}
