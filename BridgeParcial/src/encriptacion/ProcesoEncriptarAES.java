package encriptacion;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ProcesoEncriptarAES implements InterfaceEncriptar {

    @Override
    public String encryptar(String message, String password) throws Exception {
        Key key = new SecretKeySpec(password.getBytes(), "AES");
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }
}

