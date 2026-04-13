package es.etg.dam.controller;

import java.io.*;
import java.net.Socket;

import es.etg.dam.util.Conexion;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GestorClientes implements Runnable {

    private final Socket socket;
    private final CalculadoraController controller;

    private static final String RESULTADO = "Resultado: ";

    @Override
    public void run() {

        try {

            String operacion = Conexion.recibir(socket);
            String resultado = controller.procesar(operacion);
            Conexion.enviar(RESULTADO + resultado, socket);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}