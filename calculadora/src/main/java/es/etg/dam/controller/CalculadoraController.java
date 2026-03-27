package es.etg.dam.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import es.etg.dam.model.CalculadoraModel;

public class CalculadoraController {

    private static final CalculadoraModel model = new CalculadoraModel();
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

    private static final String RESULTADO = "Resultado: %.2f%n";

    private static final String NUMERO = "Número: ";
    private static final String NUMERO_1 = "Número 1: ";
    private static final String NUMERO_2 = "Número 2: ";

    private static final String CUADRADO = "1";
    private static final String SUMA = "2";
    private static final String RESTA = "3";
    private static final String MULTIPLICACION = "4";
    private static final String DIVISION = "5";
    private static final String CERO = "0";

    private static final String SALIR = "Saliendo...";
    private static final String MSG_ERROR_NUM = "Error: introduce un número válido.";

    public static void main(String[] args) throws IOException {
        String op;
        do {
            System.out.print(MSG_MENU);
            op = reader.readLine().trim();

            switch (op) {
                case CUADRADO -> {
                    try {
                        System.out.print(NUMERO);
                        String num = reader.readLine().trim();
                        double n = Double.parseDouble(num);
                        System.out.printf(RESULTADO, model.cuadrado(n));
                    } catch (NumberFormatException e) {
                        System.out.println(MSG_ERROR_NUM);
                    }
                }
                case SUMA -> operarBinaria(RESULTADO, SUMA);
                case RESTA -> operarBinaria(RESULTADO, RESTA);
                case MULTIPLICACION -> operarBinaria(RESULTADO, MULTIPLICACION);
                case DIVISION -> operarBinaria(RESULTADO, DIVISION);
                case CERO -> System.out.println(SALIR);
                default -> System.out.println(MSG_ERROR_NUM);
            }
        } while (!op.equals(CERO));
    }

    private static void operarBinaria(String formato, String tipo) throws IOException {
        try {
            System.out.print(NUMERO_1);
            String num1 = reader.readLine().trim();
            System.out.print(NUMERO_2);
            String num2 = reader.readLine().trim();

            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);

            double resultado = switch (tipo) {
                case SUMA -> model.suma(n1, n2);
                case RESTA -> model.resta(n1, n2);
                case MULTIPLICACION -> model.multiplicacion(n1, n2);
                case DIVISION -> model.division(n1, n2);
                default -> 0;
            };

            System.out.printf(formato, resultado);
        } catch (NumberFormatException e) {
            System.out.println(MSG_ERROR_NUM);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
