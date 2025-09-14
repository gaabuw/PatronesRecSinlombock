package BUILDER;

public class Usuario {
    // Atributos
    private final String nombre;
    private final String email;
    private final String direccion;
    private final String telefono;
    private final String fechaNacimiento;

    // Constructor privado
    private Usuario(Builder builder) {
        this.nombre = builder.nombre;
        this.email = builder.email;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
        this.fechaNacimiento = builder.fechaNacimiento;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    // Método toString para mostrar la información del usuario
    @Override
    public String toString() {
        return "BUILDER.Usuario: " +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '.';
    }

    // Clase Builder
    public static class Builder { //Permite configurar los atributos de manera flexible y construir el objeto BUILDER.Usuario con el método build().
        // Atributos opcionales
        private String nombre;
        private String email;
        private String direccion;
        private String telefono;
        private String fechaNacimiento;

        // Métodos para configurar los atributos
        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        // Método para construir el objeto BUILDER.Usuario
        public Usuario build() {
            return new Usuario(this);
        }
    }
}
