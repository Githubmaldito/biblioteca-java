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
                System.out.println("\nHistórico de empréstimos usuário: ");
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
            if (usuario.getMatricula().equals(matricula)) {
                System.out.println("\nUsuário encontrado!");
                for (Livro livro : alexandria.getLivros()) {
                    if (livro.getTitulo().equals(titulo)) {
                        System.out.println("\nLivro encontrado!");
                        if (!livro.getEmprestimo()) {
                            System.out.println("\nLivro disponível para empréstimo!");
                            livro.setEmprestimo(true);
                            System.out.println("\nLivro emprestado com sucesso!");
                        } else {
                            System.out.println("\nLivro já emprestado!");
                        }
                    }
                }
            }
        }
    }
}
