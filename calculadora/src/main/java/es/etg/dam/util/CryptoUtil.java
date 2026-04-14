package es.etg.dam.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import es.etg.dam.server.Servidor;
import java.security.Key;
import java.util.Base64;

public class CryptoUtil {

    private static final String ALGORITMO = "AES";
    private static final String TRANSFORMACION = "AES/ECB/PKCS5Padding";
    private static final String CONTRASEÑA = "1234567890123456";
    private static final int LONGITUD_CLAVE = 128;
    private static final int DIECISEIS = 16;

    public static String cifrar(String mensaje) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITMO);
        keyGenerator.init(LONGITUD_CLAVE);
        SecretKey keyTemp = keyGenerator.generateKey();
        Key key = new SecretKeySpec(CONTRASEÑA.getBytes(HashUtil.CODIFICACION), Servidor.CERO, DIECISEIS, ALGORITMO);

        Cipher aes = Cipher.getInstance(TRANSFORMACION);

        aes.init(Cipher.ENCRYPT_MODE, key);
        byte[] cifrado = aes.doFinal(mensaje.getBytes(HashUtil.CODIFICACION));

        return Base64.getEncoder().encodeToString(cifrado);
    }

    public static String descifrar(String mensaje) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITMO);
        keyGenerator.init(LONGITUD_CLAVE);
        SecretKey keyTemp = keyGenerator.generateKey();
        Key key = new SecretKeySpec(CONTRASEÑA.getBytes(HashUtil.CODIFICACION), Servidor.CERO, DIECISEIS, ALGORITMO);

        Cipher aes = Cipher.getInstance(TRANSFORMACION);

        aes.init(Cipher.DECRYPT_MODE, key);
        byte[] cifrado = Base64.getDecoder().decode(mensaje);
        byte[] descifrado = aes.doFinal(cifrado);

        return new String(descifrado);
    }
}