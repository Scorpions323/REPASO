package es.etg.dam.controller;

import java.net.Socket;
import java.util.Map;
import es.etg.dam.util.*;
import es.etg.dam.exceptions.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GestorClientes implements Runnable {

    private final Socket socket;
    private final CalculadoraController controller;
    private final Map<String, Integer> mapaIPs;

    @Override
    public void run() {
        try {
            String cifrado = Conexion.recibir(socket);
            if (cifrado == null) {
                throw new MensajeVacioException();
            }

            String recibido = CryptoUtil.descifrar(cifrado);
            String[] partes = recibido.split("\\|");
            if (partes.length != 2) {
                throw new FormatoInvalidoException();
            }

            String operacion = partes[0];
            String hashRecibido = partes[1];
            String hashCalc = HashUtil.hash(operacion);
            if (!hashCalc.equals(hashRecibido)) {
                throw new HashInvalidoException();
            }

            String resultado = controller.procesar(operacion);
            Conexion.enviar(resultado, socket);
        } catch (CalculadoraException e) {
            try {
                Conexion.enviar(e.getMessage(), socket);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}