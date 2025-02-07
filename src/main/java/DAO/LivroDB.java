package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import bibliotec.Livro;
import conex.Conexao;


public class LivroDB {
    public void cadastrarLivro(Livro livro){
        String sql = "INSERT INTO LIVROS (AUTOR_LIVRO, TITULO_LIVRO, EMPRESTIMO) VALUES (?, ?, ?)";

        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, livro.getAutor());
            ps.setString(2, livro.getTitulo());
            ps.setBoolean(3, livro.getEmprestimo());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
}
