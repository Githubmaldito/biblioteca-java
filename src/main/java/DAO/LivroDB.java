package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import bibliotec.Livro;
import conex.Conexao;

public class LivroDB {
    public void cadastrarLivro(Livro livro){
        String sql = "INSERT INTO LIVROS (AUTOR, TITULO, ISBN, EMPRESTIMO) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, livro.getAutor());
            ps.setString(2, livro.getTitulo());
            ps.setString(3, livro.getIsbn()); 
            ps.setBoolean(4, livro.getEmprestimo());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarLivros(){
        String sql = "SELECT * FROM LIVROS";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void emprestarLivro(String titulo, String matricula){
        String sql = "INSERT INTO EMPRESTIMOS (TITULO_LIVRO, MATRICULA_USUARIO) VALUES (?, ?)";
        String sql2 = "UPDATE LIVROS SET EMPRESTIMO = ? WHERE TITULO = ?";

        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, titulo);
            ps.setString(2, matricula);
            ps.execute();

            ps = Conexao.getConexao().prepareStatement(sql2);
            ps.setInt(1, 1);
            ps.setString(2, titulo);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void devolverLivro(String titulo){
        String sql = "UPDATE LIVROS SET EMPRESTIMO = ? WHERE TITULO = ?";
        String sql2 = "DELETE FROM EMPRESTIMOS WHERE TITULO_LIVRO = ?";

        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setString(2, titulo);
            ps.execute();

            ps = Conexao.getConexao().prepareStatement(sql2);
            ps.setString(1, titulo);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}