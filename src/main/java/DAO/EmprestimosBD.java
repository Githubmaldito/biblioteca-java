package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conex.Conexao;

public class EmprestimosBD {
    public void emprestarLivro(String titulo){
        String sql = "UPDATE LIVROS SET EMPRESTIMO = ? WHERE TITULO_LIVRO = ?";

        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setString(2, titulo);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void devolverLivro(String titulo){
        String sql = "UPDATE LIVROS SET EMPRESTIMO = ? WHERE TITULO_LIVRO = ?";

        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setString(2, titulo);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
