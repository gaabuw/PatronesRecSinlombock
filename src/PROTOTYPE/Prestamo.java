package PROTOTYPE;

import BUILDER.Usuario;
import FACTORY.Librito;

public class Prestamo implements Cloneable {
    private Librito libro;
    private Usuario usuario;
    private String fechaInicio;
    private String fechaFin;

    public Prestamo(Librito libro, Usuario usuario, String fechaInicio, String fechaFin) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y setters
    public Librito getLibro() {
        return libro;
    }

    public void setLibro(Librito libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    // Método clone (shallow copy)
    @Override
    public Prestamo clone() {
        try {
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar el préstamo", e);
        }
    }

    @Override
    public String toString() {
        return "Préstamo: Tipo=" + libro.getTipo() +
                ", título='" + libro.getTitulo() + '\'' +
                ", usuario='" + usuario.getNombre() + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'';
    }
}
