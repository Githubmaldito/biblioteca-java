package bibliotec;

import java.util.ArrayList;
import java.util.List;

//cria a classe que será a biblioteca
//classe pública permite que outras classes acessem
public class Alexandria {
//atributo privado livros que é uma lista de objetos do tipo Livro
    private List<Livro> livros;
//atributo do tipo livro que é uma lista de livros emprestados
    private List<Livro> livrosEmprestados;
// //criar uma lista com os emprestimos de usuario
//     private List<Usuario> emprestimosUsuario;

//define o construtor da classe alexandria
    public Alexandria() {
        super();
        this.livros = new ArrayList<>();
        this.livrosEmprestados = new ArrayList<>();
    }
//método que cadastra um livro
//recebe um objeto do tipo Livro como parâmetro
    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("\nLivro cadastrado com sucesso!");
    } 
//método que lista os livros
    public void listarLivros() {
//percorre a lista de livros
        for (Livro livro : livros) {
//imprime o título e o autor do livro
            System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor());
//caso o livro esteja emprestado
            if (livro.getEmprestimo() == true) {
//uma mensagem é exibida
                System.out.println(livro.getTitulo() + ", não disponível para empréstimo.\n");
            } 
        }
    }

    public List<Livro> getLivros() {

        return livros;

    }

    
//método de emprestar livro
//     public void emprestarLivro(String titulo) {
// //se o livro não estiver emprestado
//         if (livrosEmprestados.contains(titulo)) {
// //uma mensagem é exibida
//             System.out.println("Livro já emprestado!");
//             return;
//         }else{
//            for (Livro livro : livros) {
// //se o título do livro for igual ao título passado como parâmetro
//             if (livro.getTitulo().equals(titulo)) {
// //o atributo emprestimo do livro é setado como true
//                 livro.setEmprestimo(true);
// //e o livro é adicionado na lista de livros emprestados
//                 livrosEmprestados.add(livro);
//                 System.out.println("\nLivro emprestado com sucesso!");

//                 return;

//             }else{
//                 System.out.println("\nLivro não encontrado, verifique se digitou o título corretamente.");
//             }
//         }
//     } 
//         }
//percorre a lista de livros
        
//método de listar livros emprestados
    public void listarLivrosEmprestados() {
//percorre a lista de livros emprestados
        for (Livro livro : livrosEmprestados) {
//imprime o título e o autor do livro
            System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor());
        }
    }


//método de devolver livro
    public void devolverLivro(Livro livro) {
//se a lista de livros emprestados tiver o livro
        if (livrosEmprestados.contains(livro)){
//remove o livro da lista de livros emprestados
            livrosEmprestados.remove(livro);
//e adiciona o livro na lista de livros
            livros.add(livro);
            System.out.println("Livro devolvido com sucesso!");
//caso o livro não esteja na lista de emprestados
        }else{
//uma mensagem é exibida
            System.out.println("Livro não encontrado!");
        }
    }
}
