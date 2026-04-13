package es.etg.dam.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Conexion {

    public static void enviar(String msg, Socket socket) throws IOException {

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(msg);
    }

    public static String recibir(Socket socket) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return in.readLine();
    }
}