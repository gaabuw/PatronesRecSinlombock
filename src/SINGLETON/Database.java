package SINGLETON;

import FACTORY.Librito;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Librito> libros;

    private Database() {
        this.libros = new ArrayList<>();
    }

    private static class Holder {
        private static final Database INSTANCE = new Database();
    }

    public static Database getInstance() {
        return Holder.INSTANCE;
    }

    public void agregarLibro(Librito libro) {
        libros.add(libro);
    }

    public List<Librito> listarLibros() {
        return new ArrayList<>(libros);
    }
}
