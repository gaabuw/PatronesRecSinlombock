import BUILDER.Usuario;
import FACTORY.Librito;
import FACTORY.LogisticaLibro;
import PROTOTYPE.Prestamo;
import SINGLETON.Database;
import ABSTRACT_FACTORY.*;

public class Main {
    public static void main(String[] args) {
        // Obtener la instancia de la base de datos
        Database db = Database.getInstance();

        // Crear libros usando el Factory Method
        Librito libroFisico = LogisticaLibro.crearLibro("fisico", "El Principito", "Antoine de Saint-Exupéry", "123456789");
        Librito libroDigital = LogisticaLibro.crearLibro("digital", "Cien años de soledad", "Gabriel García Márquez", "987654321");

        // Agregar libros a la base de datos
        db.agregarLibro(libroFisico);
        db.agregarLibro(libroDigital);

        // Listar libros
        System.out.println("Libros en la base de datos:");
        for (Librito libro : db.listarLibros()) {
            System.out.println(libro + " - Tipo: " + libro.getTipo());
        }

        // Usar Abstract Factory para crear interfaces y métodos de envío
        AbstractFactory adminFactory = new AdminFactory();
        AbstractFactory usuarioFactory = new UsuarioFactory();

        // Crear interfaz y método de envío para administrador
        System.out.println("\n--- Configuración para Administrador ---");
        InterfazUI interfazAdmin = adminFactory.crearInterfazUI();
        MetodoEnvio envioAdmin = adminFactory.crearMetodoEnvio();
        interfazAdmin.mostrar();
        envioAdmin.enviar();

        // Crear interfaz y método de envío para usuario
        System.out.println("\n--- Configuración para Usuario ---");
        InterfazUI interfazUsuario = usuarioFactory.crearInterfazUI();
        MetodoEnvio envioUsuario = usuarioFactory.crearMetodoEnvio();
        interfazUsuario.mostrar();
        envioUsuario.enviar();

        // Crear usuarios usando el patrón Builder
        System.out.println("\n--- Usuarios creados con Builder ---");
        // Usuario 1: Solo con nombre y email
        Usuario usuario1 = new Usuario.Builder()
                .setNombre("Ana López")
                .setEmail("ana.lopez@gmail.com")
                .setTelefono("787-0389")
                .setFechaNacimiento("14/09/2004")
                .build();
        // Usuario 2: Con todos los atributos
        Usuario usuario2 = new Usuario.Builder()
                .setNombre("Carlos García")
                .setEmail("carlos.garcia@gmail.com")
                .setDireccion("Calle Principal 123")
                .setTelefono("555-1234")
                .setFechaNacimiento("15/05/1990")
                .build();
        // Mostrar información de los usuarios
        System.out.println("Usuario 1: " + usuario1);
        System.out.println("Usuario 2: " + usuario2);

        // Usar Prototype para clonar préstamos
        System.out.println("\n--- Préstamos creados con Prototype ---");

        // Crear préstamo prototipo
        Prestamo prestamoPrototipo = new Prestamo(libroFisico, usuario1, "01/09/2025", "15/09/2025");
        System.out.println("Préstamo prototipo: " + prestamoPrototipo);

        // Clonar préstamo 1 y modificar algunos atributos
        Prestamo prestamo1 = prestamoPrototipo.clone();
        prestamo1.setLibro(libroDigital);
        prestamo1.setUsuario(usuario2);
        prestamo1.setFechaInicio("02/09/2025");
        prestamo1.setFechaFin("16/09/2025");

        // Clonar préstamo 2 y modificar algunos atributos
        Prestamo prestamo2 = prestamoPrototipo.clone();
        prestamo2.setFechaInicio("03/09/2025");
        prestamo2.setFechaFin("17/09/2025");

        // Mostrar información de los préstamos clonados
        System.out.println("Préstamo 1: " + prestamo1);
        System.out.println("Préstamo 2: " + prestamo2);

        // Verificar que los clones son independientes del original
        System.out.println("\n--- Verificación de independencia ---");
        System.out.println("Préstamo prototipo: " + prestamoPrototipo);
        System.out.println("Préstamo 1: " + prestamo1);
        System.out.println("Préstamo 2: " + prestamo2);
    }
}

