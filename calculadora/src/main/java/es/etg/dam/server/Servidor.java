package es.etg.dam.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import es.etg.dam.controller.*;

public class Servidor {

    public static final int PUERTO = 8080;
    private static final String ESCUCHA = "Servidor escuchando...";
    private static final String IP = "IP: ";
    private static final String PETICIONES = " | peticiones: ";
    public static final int CERO = 0;
    private static final int UNO = 1;

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(PUERTO);
        Map<String, Integer> mapaIPs = new HashMap<>();
        CalculadoraController controller = new CalculadoraController();
        System.out.println(ESCUCHA);

        while (true) {
            Socket s = ss.accept();
            String ip = s.getInetAddress().getHostAddress();
            mapaIPs.put(ip, mapaIPs.getOrDefault(ip, CERO) + UNO);
            System.out.println(IP + ip + PETICIONES + mapaIPs.get(ip));
            new Thread(new GestorClientes(s, controller, mapaIPs)).start();
        }
    }
}