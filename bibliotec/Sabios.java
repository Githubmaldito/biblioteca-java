package bibliotec;
import java.util.ArrayList;
import java.util.List;

public class Sabios {
//criação de uma lista de usuários do tipo Usuario    
    private List<Usuario> usuarios;
    private List<Livro> livros;

    public Sabios() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("\nUsuário cadastrado com sucesso!");
    }
    public void listarUsuarios(){
        for (Usuario usuario : usuarios){
            System.out.println("Nome: " + usuario.getNome() + ", Email: " + usuario.getEmail() + ", Matrícula: " + usuario.getMatricula());
        }
    }
    //criar histório de empréstimos do usuário
    public void historicoEmprestimos(String matricula){
        for (Usuario usuario : usuarios){
            if (usuario.getMatricula().equals(matricula)){
                System.out.println("\nUsuário encontrado!");
                System.out.println("\nHistórico de empréstimos do usuário: ");
                for (Livro livro : livros){
                    if (livro.getEmprestimo() == true){
                        System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor());
                    }
                }
            }
        }
    }
    
    //emprestar livro ao usuário]
    public void emprestarLivro(String titulo, String matricula){
        for (Usuario usuario : usuarios){
            if (usuario.getMatricula().equals(matricula)){
                System.out.println("\nUsuário encontrado!");
                for (Livro livro : livros){
                    if (livro.getTitulo().equals(titulo)){
                        System.out.println("\nLivro encontrado!");
                        if (livro.getEmprestimo() == false){
                            System.out.println("\nLivro disponível para empréstimo!");
                            livro.setEmprestimo(true);
                            System.out.println("\nLivro emprestado com sucesso!");
                        }else{
                            System.out.println("\nLivro já emprestado!");
                        }
                    }
                }
            }
        }
    }
}
