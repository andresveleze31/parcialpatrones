package patronbridge;

import encriptacion.EncryptionFactory;
import encriptacion.InterfaceEncriptar;
import implementacion.PuenteMensajeEncriptacion;
import implementacion.InterfaceMensajeEncriptacion;

public class PatronBridgeMain {

    public static void main(String[] args) {
        try {
            // Usar el Factory para obtener el proceso de encriptación adecuado
            InterfaceEncriptar procesoEncriptacion = EncryptionFactory.getEncryptionProcess();
            InterfaceMensajeEncriptacion puente = new PuenteMensajeEncriptacion(procesoEncriptacion);

            // Mensaje a encriptar
            final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
            String password = "HG58YZ3CR9123456";  // Cambiar según el tipo de encriptación

            // Encriptar el mensaje usando el tipo de encriptación configurado
            String mensajeEncriptado = puente.EncryptarMensaje(message, password);
            System.out.println("Mensaje Encriptado > " + mensajeEncriptado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
