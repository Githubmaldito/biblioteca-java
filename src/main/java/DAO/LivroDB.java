package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    // public void listarLivros(){
    //     String sql = "SELECT * FROM LIVROS";
    //     PreparedStatement ps = null;
    //     try {
    //         ps = Conexao.getConexao().prepareStatement(sql);
    //         ps.execute();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }

    public void listarLivros() {
        //se conecta ao bd usando a o método da classe Conexao
        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM livros")) {

            System.out.println("\n--- Lista de Livros ---");

            while (rs.next()) {
                //enquanto houver livros, vai pegar pegar as colunas do banco de dados
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String isbn = rs.getString("isbn");
                boolean emprestado = rs.getBoolean("emprestimo");

                // e exibir no terminal
                System.out.println("Título: " + titulo);
                System.out.println("Autor: " + autor);
                System.out.println("ISBN: " + isbn);
                System.out.println("Status: " + (emprestado ? "Emprestado" : "Disponível"));
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao listar livros: " + e.getMessage());
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