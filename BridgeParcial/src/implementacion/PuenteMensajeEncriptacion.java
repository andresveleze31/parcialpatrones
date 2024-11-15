package implementacion;

import encriptacion.InterfaceEncriptar;

public class PuenteMensajeEncriptacion implements InterfaceMensajeEncriptacion {
    private InterfaceEncriptar procesoEncriptacion;

    public PuenteMensajeEncriptacion(InterfaceEncriptar procesoEncriptacion) {
        this.procesoEncriptacion = procesoEncriptacion;
    }

    @Override
    public String EncryptarMensaje(String message, String password) throws Exception {
        return procesoEncriptacion.encryptar(message, password);
    }
}
