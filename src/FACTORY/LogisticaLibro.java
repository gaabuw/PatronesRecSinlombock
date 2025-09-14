package FACTORY;

public class LogisticaLibro {
    public static Librito crearLibro(String tipo, String titulo, String autor, String isbn) {
        switch (tipo.toLowerCase()) {
            case "fisico":
                return new LibroFisico(titulo, autor, isbn);
            case "digital":
                return new LibroDigital(titulo, autor, isbn);
            default:
                throw new IllegalArgumentException("Tipo de libro desconocido: " + tipo);
        }
    }
}

