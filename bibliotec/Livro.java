package bibliotec;
public class Livro {
    private String titulo;
    private String autor;

//constructor do livro
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
//getters e setters com os campos do livro
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}

