package ABSTRACT_FACTORY;

public class AdminFactory implements AbstractFactory {
    @Override
    public InterfazUI crearInterfazUI() {
        return new AdminUI();
    }

    @Override
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioExpress();
    }
}
