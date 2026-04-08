package es.etg.dam.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import es.etg.dam.model.CalculadoraModel;
import es.etg.dam.model.ContadorOperaciones;

public class CalculadoraController {

    private static final CalculadoraModel model = new CalculadoraModel();
    private static final ContadorOperaciones contadores = new ContadorOperaciones();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final String MSG_MENU = """
            Menu:
            1. Cuadrado
            2. Suma
            3. Resta
            4. Multiplicación
            5. División
            0. Salir
            Elige una opción: """;

    private static final String NUMERO = "\nNúmero: ";
    private static final String NUMERO_1 = "\nNúmero 1: ";
    private static final String NUMERO_2 = "Número 2: ";

    public static final String CUADRADO = "1";
    public static final String SUMA = "2";
    public static final String RESTA = "3";
    public static final String MULTIPLICACION = "4";
    public static final String DIVISION = "5";
    public static final String CERO = "0";

    private static final String SALIR = "\nSaliendo...";
    private static final String MSG_ERROR_NUM = "\nError: introduce un número válido.";
    public static final String MSG_OPCION = "\nOpción no válida.";

    private static final String CONTADOR_FINAL = """
            \nConteo Final:
            Cuadrado: %d
            Suma: %d
            Resta: %d
            Multiplicación: %d
            División: %d
            """;

    public static void main(String[] args) throws IOException {

        String op;

        do {
            System.out.println();
            System.out.print(MSG_MENU);
            op = reader.readLine().trim();

            Thread hilo = null;

            switch (op) {

                case CUADRADO -> {
                    try {
                        System.out.print(NUMERO);
                        double n = Double.parseDouble(reader.readLine().trim());
                        hilo = new OperacionHilo(model, contadores, op, n, 0);
                    } catch (NumberFormatException e) {
                        System.out.println(MSG_ERROR_NUM);
                    }
                }

                case SUMA, RESTA, MULTIPLICACION, DIVISION -> {
                    try {
                        System.out.print(NUMERO_1);
                        double n1 = Double.parseDouble(reader.readLine().trim());
                        System.out.print(NUMERO_2);
                        double n2 = Double.parseDouble(reader.readLine().trim());

                        hilo = new OperacionHilo(model, contadores, op, n1, n2);
                    } catch (NumberFormatException e) {
                        System.out.println(MSG_ERROR_NUM);
                    }
                }

                case CERO -> {
                    System.out.println(SALIR);
                    mostrarConteo();
                }

                default -> System.out.println(MSG_OPCION);
            }

            if (hilo != null) {
                hilo.start();
                try {
                    hilo.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } while (!CERO.equals(op));
    }

    private static void mostrarConteo() {
        System.out.printf(CONTADOR_FINAL,
                contadores.getCuadrado(),
                contadores.getSuma(),
                contadores.getResta(),
                contadores.getMultiplicacion(),
                contadores.getDivision());
    }
}