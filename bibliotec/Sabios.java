package bibliotec;
import java.util.ArrayList;
import java.util.List;

public class Sabios {
//criação de uma lista de usuários do tipo Usuario    
    private List<Usuario> usuarios;

    public Sabios() {
        super();
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
}
