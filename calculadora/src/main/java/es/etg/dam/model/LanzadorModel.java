package es.etg.dam.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzadorModel {

    private static final String JAVA = "java";
    private static final String CP = "-cp";
    private static final String TARGET_CLASSES = "target/classes";
    private static final String CALCULADORA_CONTROLLER = "es.etg.dam.controller.CalculadoraController";
    private static final String RUTA_COMPLETA = "/home/debian/Documents/REPASO/calculadora";
    private static final String MSG_ERROR = "Error al ejecutar el proceso: ";

    public String lanzar(int numero) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(JAVA, CP, TARGET_CLASSES,
                CALCULADORA_CONTROLLER, String.valueOf(numero));

        pb.directory(new java.io.File(RUTA_COMPLETA));

        Process process = pb.start();
        BufferedReader entrada = new BufferedReader(new InputStreamReader(process.getInputStream()));

        StringBuilder salida = new StringBuilder();
        String linea;

        while ((linea = entrada.readLine()) != null) {
            salida.append(linea).append("\n");
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException(MSG_ERROR + exitCode);
        }

        return salida.toString().trim();
    }
}
