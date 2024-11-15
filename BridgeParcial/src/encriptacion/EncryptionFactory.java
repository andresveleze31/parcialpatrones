package encriptacion;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EncryptionFactory {

    public static InterfaceEncriptar getEncryptionProcess() throws Exception {
        Properties config = new Properties();

        try (FileInputStream configFile = new FileInputStream("config.properties")) {
            config.load(configFile);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de configuración", e);
        }

        String encryptionType = config.getProperty("encryptionType");

        switch (encryptionType) {
            case "AES":
                return new ProcesoEncriptarAES();
            case "DES":
                return new ProcesoEncriptarDES();
            case "NONE":
                return new ProcesoSinEncriptar();
            default:
                throw new IllegalArgumentException("Tipo de encriptación no soportado: " + encryptionType);
        }
    }
}
