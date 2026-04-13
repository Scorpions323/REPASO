package es.etg.dam.view;

import java.io.IOException;
import java.net.Socket;

import es.etg.dam.util.Conexion;
import static es.etg.dam.server.Servidor.PUERTO;

public class Cliente {
    public static final String HOST = "localhost";

    public static void main(String[] args) {

        try (Socket socket = new Socket(HOST, PUERTO)) {

            Conexion.enviar(args[0], socket);
            String respuesta = Conexion.recibir(socket);
            System.out.println(respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}