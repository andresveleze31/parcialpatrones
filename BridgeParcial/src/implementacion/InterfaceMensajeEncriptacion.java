package implementacion;

import encriptacion.InterfaceEncriptar;

public interface InterfaceMensajeEncriptacion {
    public String EncryptarMensaje(String message, String password) throws Exception;
}
