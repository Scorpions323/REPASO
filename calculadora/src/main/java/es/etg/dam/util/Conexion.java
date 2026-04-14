package es.etg.dam.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Conexion {

    public static void enviar(String msg, Socket s) throws IOException {
        new PrintWriter(s.getOutputStream(), true).println(msg);
    }

    public static String recibir(Socket s) throws IOException {
        return new BufferedReader(
                new InputStreamReader(s.getInputStream())).readLine();
    }
}