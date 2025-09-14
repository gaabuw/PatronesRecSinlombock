package FACTORY;

public class LibroDigital implements Librito {
    private String titulo;
    private String autor;
    private String isbn;

    public LibroDigital(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getTipo() {
        return "Libro Digital";
    }

    @Override
    public String toString() {
        return "LibroDigital: " + "titulo='" + titulo + '\'' + ", autor='" + autor + '\'' + ", isbn='" + isbn + '\'' + '.';
    }
}
