package encriptacion;

public class ProcesoSinEncriptar implements InterfaceEncriptar {

    @Override
    public String encryptar(String message, String password) {
        return message;
    }
}
