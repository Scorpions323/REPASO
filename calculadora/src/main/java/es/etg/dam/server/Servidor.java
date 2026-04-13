package es.etg.dam.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import es.etg.dam.controller.CalculadoraController;
import es.etg.dam.controller.GestorClientes;

public class Servidor {

    public static final int PUERTO = 8080;
    private static final String ESCUCHA = "Servidor escuchando...";

    private static final String IP = "IP: ";
    private static final String PETICIONES = " | peticiones: ";

    private static final int CERO = 0;
    private static final int UNO = 1;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PUERTO);

        System.out.println(ESCUCHA);
        CalculadoraController controller = new CalculadoraController();
        Map<String, Integer> peticionesPorIP = new HashMap<>();

        while (true) {

            Socket socket = serverSocket.accept();
            String ip = socket.getInetAddress().getHostAddress();
            peticionesPorIP.put(ip, peticionesPorIP.getOrDefault(ip, CERO) + UNO);

            System.out.println(IP + ip + PETICIONES + peticionesPorIP.get(ip));

            new Thread(new GestorClientes(socket, controller)).start();
        }
    }
}