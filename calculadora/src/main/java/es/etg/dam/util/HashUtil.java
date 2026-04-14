package es.etg.dam.util;

import java.security.MessageDigest;

public class HashUtil {

    private static final String ALGORITMO = "SHA-256";
    public static final String CODIFICACION = "UTF-8";

    public static String hash(String cadena) throws Exception {
        MessageDigest md = null;
        byte[] hash = null;
        md = MessageDigest.getInstance(ALGORITMO);
        hash = md.digest(cadena.getBytes(CODIFICACION));
        return bytesToHex(hash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}