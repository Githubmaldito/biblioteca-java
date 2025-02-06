package bibliotec;
import java.util.ArrayList;
import java.util.List;

public class Sabios {
    private List<Usuario> usuarios;
    private Alexandria alexandria;

    public Sabios(Alexandria alexandria) {
        this.usuarios = new ArrayList<>();
        this.alexandria = alexandria;
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("\nUsuário cadastrado com sucesso!");
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println("Nome: " + usuario.getNome() + ", Email: " + usuario.getEmail() + ", Matrícula: " + usuario.getMatricula());
        }
    }

    public void historicoEmprestimos(String matricula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                System.out.println("\nUsuário encontrado!");
                System.out.println("\nHistórico de empréstimos usuário " + usuario.getNome() + ":");
                for (Livro livro : alexandria.getLivros()) {
                    if (livro.getEmprestimo()) {
                        System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor());
                    }
                }
            }
        }
    }

    public void emprestarLivro(String titulo, String matricula) {
        for (Usuario usuario : usuarios) {
//vê os usuários que estão cadastrados na classe Sabios
            if (usuario.getMatricula().equals(matricula)) {
//caso a matrícula do usuário seja igual a matrícula passada como parâmetro
                System.out.println("\nUsuário encontrado!");
//o usuário é encontrado
                for (Livro livro : alexandria.getLivros()) {
//depois vê os livros que estão cadastrados na biblioteca da classe Alexandria
                    if (livro.getTitulo().equals(titulo)) {
//caso o título do livro seja igual ao título passado como parâmetro
                        if (!livro.getEmprestimo()) {
//se o livro não estiver emprestado
                            livro.setEmprestimo(true);
//o livro é emprestado
                            System.out.println("\nLivro emprestado com sucesso!");
                            return;
                        } else {
                            System.out.println("\nLivro já emprestado!");
                            return;
                        }
                    }
                }
                System.out.println("\nLivro não encontrado!");
                return;
            }
        }
        System.out.println("\nUsuário não encontrado!");
    }

    //método de devolver livros emrestados
    public void devolverLivro(String titulo) {
        for (Livro livro : alexandria.getLivros()) {
//vê os livros que estão cadastrados na biblioteca da classe Alexandria
            if (livro.getTitulo().equals(titulo)) {
//se o titulo do livro for igual ao titulo passado como parâmetro
                System.out.println("\nLivro encontrado!");
                if (livro.getEmprestimo()) {
//se o livro estiver emprestado
                    System.out.println("\nLivro devolvido com sucesso!");
//ele é devolvido
                    livro.setEmprestimo(false);
//e o status de emprestado é setado como false
                    return;
                } else {
                    System.out.println("\nLivro não emprestado!");
                    return;
                }
            }
        }
        System.out.println("\nLivro não encontrado!");
    }
}
