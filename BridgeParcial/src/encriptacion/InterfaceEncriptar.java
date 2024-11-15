package encriptacion;

/**
 * Interface común para todas las implementaciones de algoritmos de encriptamiento.
 */
public interface InterfaceEncriptar {
    public String encryptar(String message, String password) throws Exception;
}
