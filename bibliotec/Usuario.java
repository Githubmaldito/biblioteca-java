//quando o nome do package era "biblioteca" o código não funcionava
package bibliotec;
public class Usuario{
    private String nome;
    private String email;
    private String matricula;


//constructor de usuario
    public Usuario(String nome, String email, String matricula){
    this.nome = nome;
    this.email = email;
    this.matricula = matricula;
    }

//getters e setters com os campos do usuario
    public String getNome(){
        return nome;
    }public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }public void setEmail(String email){
        this.email = email;
    }
    
    public String getMatricula(){
        return matricula;
    }public void setMatricula(String matricula){
        this.matricula = matricula;
    }
}

