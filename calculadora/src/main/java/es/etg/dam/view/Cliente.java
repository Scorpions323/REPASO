package es.etg.dam.view;

import java.net.Socket;

import es.etg.dam.server.Servidor;
import es.etg.dam.util.Conexion;
import es.etg.dam.util.CryptoUtil;
import es.etg.dam.util.HashUtil;

public class Cliente {

    public static final String HOST = "localhost";
    private static final String BARRA = "|";

    public static void main(String[] args) {
        try (Socket s = new Socket(HOST, Servidor.PUERTO)) {
            String operacion = args[0];
            String hash = HashUtil.hash(operacion);
            String mensaje = operacion + BARRA + hash;
            String cifrado = CryptoUtil.cifrar(mensaje);
            Conexion.enviar(cifrado, s);
            System.out.println(Conexion.recibir(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}