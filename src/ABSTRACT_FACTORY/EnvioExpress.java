package ABSTRACT_FACTORY;

public class EnvioExpress implements MetodoEnvio {
    @Override
    public void enviar() {
        System.out.println("Enviando por método express (1-2 días).");
    }
}
