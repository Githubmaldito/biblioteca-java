package DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bibliotec.Usuario;
import conex.Conexao;

public class UserDB {
    public void cadastrarUsuario(Usuario usuario){
        String sql = "INSERT INTO USUARIOS (NOME, MATRICULA, EMAIL) VALUES (?, ?, ?)";

        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getMatricula());
            ps.setString(3, usuario.getEmail());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarUsuarios(){
        String sql = "SELECT * FROM USUARIOS";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void historicoEmprestimos(String matricula){
        String sql = "SELECT * FROM EMPRESTIMOS WHERE MATRICULA_USUARIO = ?";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, matricula);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
