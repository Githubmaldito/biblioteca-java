package bibliotec;
public class Livro {
    private String titulo;
    private String autor;
    private boolean emprestado;

//constructor do livro
    public Livro(String titulo, String autor, boolean emprestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = emprestado;
    }

//getters e setters com os campos do livro
    public String getTitulo() {
        return titulo;
    }public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean getEmprestimo() {
        return emprestado;
    }public void setEmprestimo(boolean emprestado) {
        this.emprestado = emprestado;
    }

}

